import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'
import Cliente from '../components/Cliente.vue'
import Corretor from '../components/Corretor.vue'
import Imovel from '../components/Imovel.vue'
import Aluguel from '../components/Aluguel.vue'
import Venda from '../components/Venda.vue'


Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  },
  {
    path: '/cliente',
    name: 'Clientes',
    component: Cliente
  },
  {
    path: '/corretor',
    name: 'Corretores',
    component: Corretor
  },
  {
    path: '/imovel',
    name: 'Imoveis',
    component: Imovel
  },
  {
    path: '/aluguel',
    name: 'Aluguel',
    component: Aluguel
  },
  {
    path: '/venda',
    name: 'Venda',
    component: Venda
  },
  {
    path: '*',
    beforeEnter: (to, from, next) => { next('/404') }
  },
  {
    path: '/404',
    name: '404',
    component: () => import('../views/NotFound.vue')
  }
]

const router = new VueRouter({
  routes
})

export default router
