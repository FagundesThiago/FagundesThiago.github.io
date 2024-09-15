<template>
  <v-app id="inspire">
    <v-navigation-drawer v-model="drawer" app>
      <v-list-item>
        <v-list-item-content>
          <v-list-item-title class="text-h6">
            Imobiliária Web
          </v-list-item-title>
          <v-list-item-subtitle>
            Simplicidade é agilidade!
          </v-list-item-subtitle>
        </v-list-item-content>
      </v-list-item>

      <v-divider></v-divider>

      <v-list dense nav>
        <v-list-item v-for="item in items" :key="item.title" :to="item.to" link>
          <v-list-item-icon>
            <v-icon>{{ item.icon }}</v-icon>
          </v-list-item-icon>

          <v-list-item-content>
            <v-list-item-title>{{ item.title }}</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-list>
    </v-navigation-drawer>
    <v-app-bar app color="primary" dark src="img.jpg" prominent>
      <template v-slot:img="{ props }">
        <v-img v-bind="props" gradient="to top right, rgba(19,84,122,.5), rgba(128,208,199,.8)"></v-img>
      </template>

      <v-app-bar-nav-icon @click="drawer=!drawer"></v-app-bar-nav-icon>

      <v-app-bar-title>Imobiliária Web</v-app-bar-title>

      <v-spacer></v-spacer>

      <v-btn icon>
        <v-icon>mdi-dots-vertical</v-icon>
      </v-btn>
    </v-app-bar>

    <v-main>
      <router-view></router-view>
    </v-main>
  </v-app>
</template>

<script>
export default {
  data: () => ({
    drawer: null,
    items: [
      { title: 'Página Inicial', icon: 'mdi-home', to: '/' },
      { title: 'Clientes', icon: 'mdi-account-multiple', to: '/cliente' },
      { title: 'Corretores', icon: 'mdi-account-multiple', to: '/corretor' },
      { title: 'Imóveis', icon: 'mdi-home-city', to: '/imovel' },
      { title: 'Aluguel', icon: 'mdi-file-document-edit-outline', to: '/aluguel' },
      { title: 'Venda', icon: 'mdi-file-document-edit-outline', to: '/venda' },
      { title: 'Sobre', icon: 'mdi-help-box', to: '/about' },
    ],
  }),
}
</script>
