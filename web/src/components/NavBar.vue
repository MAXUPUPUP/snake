<template>
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container">
      <router-link class="navbar-brand" :to="{ name: 'home' }">Game!Fighting!</router-link>

      <div class="collapse navbar-collapse" id="navbarText">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
          <li class="nav-item">
            <router-link :class="route_name == 'pk_index' ? 'nav-link active' : 'nav-link'"
              :to="{ name: 'pk_index' }">游戏对战</router-link>
          </li>
          <li class="nav-item">
            <router-link :class="route_name == 'record_index' ? 'nav-link active' : 'nav-link'"
              :to="{ name: 'record_index' }">战绩查询</router-link>
            <!-- 这是在完全前后端分离，不用再加载 -->
            <!-- active的位置，决定高亮在哪 -->
          </li>
          <li class="nav-item">
            <router-link :class="route_name == 'ranklist_index' ? 'nav-link active' : 'nav-link'"
              :to="{ name: 'ranklist_index' }">排位天梯</router-link>
          </li>
        </ul>
        <ul class="navbar-nav" v-if="$store.state.user.is_login">
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
              {{ $store.state.user.username }}
            </a>
            <ul class="dropdown-menu">
              <li><a class="dropdown-item" href="#">暂定</a></li>
              <li><router-link class="dropdown-item" :to="{ name: 'user_bot_index' }">我的Bots</router-link></li>
              <li>
                <hr class="dropdown-divider">
              </li>
              <li><a class="dropdown-item" href="#" @click="logout">退出</a></li>
            </ul>
          </li>
        </ul>

        <ul class="navbar-nav" v-else-if="!$store.state.user.pulling_info">
          <li class="nav-item">
            <router-link class="nav-link" :to="{ name: 'user_account_login' }" role="button">
              登录
            </router-link>
          </li>
          <li class="nav-item">
            <router-link class="nav-link" :to="{ name: 'user_account_register' }" role="button">
              注册
            </router-link>
          </li>
        </ul>

      </div>
    </div>
  </nav>
</template>

<script>
// active的位置，决定高亮在哪
import { useRoute } from 'vue-router'
import { computed } from 'vue'
import { useStore } from 'vuex'

export default {
  setup() {
    const store = useStore();
    const route = useRoute();
    let route_name = computed(() => route.name)

    const logout = () => {
      store.dispatch("logout");

    }

    return {
      route_name,
      logout
    }

  }
}

</script>

<style scoped>



</style>