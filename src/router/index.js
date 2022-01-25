import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'

Vue.use(Router)

// /a/b /a/c /a/d
export default new Router({
  routes: [{
      path: '/',
      redirect: {
        name: 'Login'
      },
    },
    {
      path: '/Login',
      name: 'Login',
      component: () => import('../components/Login.vue')
    },
    {
      path: '/DashBoard',
      name: 'DashBoard',
      component: () => import('../components/DashBoard.vue')
    }
  ]
})
