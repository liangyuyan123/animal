import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import AdminLogin from '@/components/AdminLogin'
import AdminIndex from '@/components/AdminIndex'
import Test from '@/components/Test'
import AdminPets from '@/components/AdminPets'
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
	{
	  path: '/AdminLogin',
	  name: 'AdminLogin',
	  component: AdminLogin
	},
  {
    path: '/AdminIndex',
    name: 'AdminIndex',
    component: AdminIndex,
    children: [

            {
              path: '/Test',
              name: 'Test',
              component: Test
            },
            {
              path: '/AdminPets',
              name: 'AdminPets',
              component: AdminPets
            }
            ]
  }
  ]
})
