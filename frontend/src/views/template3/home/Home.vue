<template>
  <v-app id="inspire">
    <v-navigation-drawer
      v-model="drawer"
      app
      right
      
    >
      <v-list dense>

        <v-list-item link>
          <v-list-item-action>
            <v-icon>mdi-home</v-icon>
          </v-list-item-action>

          <v-list-item-content>
            <router-link :to="{ name: 'list3' }"><v-list-item-title>Home</v-list-item-title></router-link>
          </v-list-item-content>
        </v-list-item>
 
        <v-list-item link>
          <v-list-item-action>
            <v-icon>mdi-email</v-icon>
          </v-list-item-action>

          <v-list-item-content>
            <v-list-item-title>Contact</v-list-item-title>
          </v-list-item-content>
        </v-list-item>

        <v-list-item link>
          <v-list-item-action>
            <v-icon>mdi-tag</v-icon>
          </v-list-item-action>

          <v-list-item-content>
            <v-list-item-title>Tag</v-list-item-title>
          </v-list-item-content>
        </v-list-item>

        <v-list-item link>
          <v-list-item-action>
            <v-icon>fas fa-child</v-icon>
          </v-list-item-action>

          <v-list-item-content>
            <v-list-item-title>Visit</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-list>
    </v-navigation-drawer>

    <v-app-bar
      app
      color="blue lighten-3"
      dark
    >
      <v-spacer></v-spacer>

      <v-toolbar-title>Myblog</v-toolbar-title>

      <v-app-bar-nav-icon @click.stop="drawer = !drawer"></v-app-bar-nav-icon>
    </v-app-bar>

    <v-main>
      <LikeList class="mt-3" />
      <v-container
        class="fill-height"
        fluid
      >
            <RecentList />
        <v-row
          align="center"
          justify="center"
        >
          <v-col class="text-center">
          </v-col>
        </v-row>
      </v-container> 
    </v-main>

    <v-footer
      color="blue lighten-3"
      app
    >
      <v-spacer></v-spacer>

      <span class="white--text">&copy; {{ new Date().getFullYear() }}</span>
    </v-footer>
  </v-app>
</template>

<script>
import LikeList from '@/views/template3/post/LikeList.vue'
import RecentList from '@/views/template3/post/RecentList.vue'
  export default {
    name: 'LayoutsDemosBaselineFlipped',
    props: {
      source: String,
    },
    components: {
      LikeList,
      RecentList
    },
    data: () => ({
      drawer: null,
    }),
  }
</script>