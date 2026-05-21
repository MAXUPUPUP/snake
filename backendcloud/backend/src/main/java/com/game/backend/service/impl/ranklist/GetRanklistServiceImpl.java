package com.game.backend.service.impl.ranklist;

import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.game.backend.RankListInitializer;
import com.game.backend.mapper.UserMapper;
import com.game.backend.pojo.User;
import com.game.backend.service.ranklist.GetRanklistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GetRanklistServiceImpl implements GetRanklistService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private StringRedisTemplate redisTemplate;


//
//    @Override
//    public JSONObject getList (Integer page){
//        IPage<User> userIPage = new Page<>(page, 10);
//        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
//        queryWrapper.orderByDesc("rating");
//        List<User> users = userMapper.selectPage(userIPage, queryWrapper).getRecords();
//        JSONObject resp = new JSONObject();
//        for (User user : users)
//            user.setPassword("");
//            resp.put("users", users);
//            resp.put("users_count", userMapper.selectCount(null));
//            return resp;
//        }

    @Override
    public JSONObject getList(Integer page){
        long start = (page - 1) * 10L;
        long end = start + 9;
        Set<String> sortedUserIds = redisTemplate.opsForZSet().reverseRange(RankListInitializer.RANK_KEY, start, end);

        if(sortedUserIds == null || sortedUserIds.isEmpty()){
            JSONObject emptyResp = new JSONObject();
            emptyResp.put("users", new ArrayList<>());
            emptyResp.put("users_count", redisTemplate.opsForZSet().zCard(RankListInitializer.RANK_KEY));
            return emptyResp;
        }

        List<Integer> sortedUserIdList = new ArrayList<>();
        for(String userId : sortedUserIds){
            sortedUserIdList.add(Integer.parseInt(userId));
        }

        List<User> users = userMapper.selectBatchIds(sortedUserIdList);
        JSONObject resp = new JSONObject();

        Map<Integer, User> userMap = new HashMap<>();
        for(User user : users){
            userMap.put(user.getId(), user);
        }
        List<User> sortedUsers = new ArrayList<>();
        for(Integer id : sortedUserIdList){
            sortedUsers.add(userMap.get(id));
        }

        for(User user : sortedUsers){
            user.setPassword("");
        }
        resp.put("users", sortedUsers);
        resp.put("users_count", redisTemplate.opsForZSet().zCard(RankListInitializer.RANK_KEY));
        return resp;
    }

}
