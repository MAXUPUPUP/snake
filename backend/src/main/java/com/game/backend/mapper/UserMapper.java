package com.game.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.game.backend.pojo.User;
import org.apache.ibatis.annotations.Mapper;

//不用写sql语句辣QAQ
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
