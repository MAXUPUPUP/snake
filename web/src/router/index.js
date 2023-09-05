import { createRouter, createWebHistory } from 'vue-router'
import PkindexView from '../views/pk/PkindexView'
import RanklistindexView from '../views/ranklist/RanklistindexView'
import RecordindexView from '../views/record/RecordindexView'
import RecordContentView from '../views/record/RecordContentView'
import UserBotindexView from '../views/user/bot/UserBotindexView'
import NotFound from '../views/error/NotFound'
import UserAccountLoginView from '../views/user/account/UserAccountLoginView'
import UserAccountRegisterView from '../views/user/account/UserAccountRegisterView'
import store from '@/store'

const routes = [
  {
    path: "/pk/",
    name: "pk_index",
    component: PkindexView,
    meta: {
      requestAuth: true,
    }
  },

  {
    path: "/record/",
    name: "record_index",
    component: RecordindexView,
    meta: {
      requestAuth: true,
    }
  },

  {
    path: "/record/:recordId/",
    name: "record_content",
    component: RecordContentView,
    meta: {
      requestAuth: true,
    }
  },


  {
    path: "/ranklist/",
    name: "ranklist_index",
    component: RanklistindexView,
    meta: {
      requestAuth: true,
    }
  },

  {
    path: "/user/bot/",
    name: "user_bot_index",
    component: UserBotindexView,
    meta: {
      requestAuth: true,
    }
  },
  {
    path: "/user/account/login/",
    name: "user_account_login",
    component: UserAccountLoginView,
    meta: {
      requestAuth: false,
    }
  },

  {
    path: "/user/account/register/",
    name: "user_account_register",
    component: UserAccountRegisterView,
    meta: {
      requestAuth: false,
    }
  },



  {
    path: "/404/",
    name: "404",
    component: NotFound,
    meta: {
      requestAuth: false,
    }
  },
  {
    path: "/",
    name: "home",
    redirect: "/pk/",
    meta: {
      requestAuth: true,
    }
  },

  {
    path: "/:catchAll(.*)",
    redirect: "/404/"
  }

]

const router = createRouter({
  history: createWebHistory(),
  routes
})


router.beforeEach((to, from, next) => {
  if(to.meta.requestAuth && !store.state.user.is_login) {
    next({name: "user_account_login"})
  }
  else{
    next();
  }

})

export default router
