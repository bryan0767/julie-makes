<template>
  <v-app v-if="!loading" id="rootGrid">
      <HomePage :data="$store.state.Admin.data['home']" />
      <PortfolioPage :data="$store.state.Admin.data['portfolio']" />
      <AboutPage :data="$store.state.Admin.data['about']" />
      <ContactPage :data="$store.state.Admin.data['contact']" />
      <SpeedDial />
  </v-app>
</template>

<script>

import HomePage from "./HomePage.vue"
import AboutPage from "./AboutPage.vue"
import ContactPage from "./ContactPage.vue"
import PortfolioPage from "./PortfolioPage.vue"
import SpeedDial from "./SpeedDial.vue"

  export default {
    name: "App",
    components: {
      HomePage,
      AboutPage,
      ContactPage,
      PortfolioPage,
      SpeedDial
    },
    created: function() {
      fetch("/getAll").then(x => x.json())
                      .then(y => {
                        this.$store.dispatch("Admin/setData", y)
                                    .then(res => {
                                      this.loading = false
                                    })
                      })
    },
    data() {
      return {
        loading: true
      }
    },
    methods: {
      toAdmin() {
        this.$router.push("/admin")
      }
    }
  }

</script>

<style lang="scss">

  .adminButton {
    color:white;
    position:fixed;
    height:70px;
    width:70px;
    border-radius:50px;
    right: 15px;
    top:15px;
    border:2px solid pink;
    text-align:center;
    display:flex;
    justify-content:center;
    align-items:center;
  }

  .col {
    padding:0;
  }

  .row {
    margin-right:0;
    margin-left:0;
  }

  .v-expansion-panels {
    z-index: 99999;
  }

  .rootPage {
    height:100vh;
    width:100vw;
    max-width:1100px;
  }

  .grid {
    height:100vh;
    width:100vw;
    position:absolute;
  }

  #rootGrid {
    width:100vw;
    position:relative;
    overflow:hidden;
      .md-overlay {
        display:none;
      }
  }

  html {
    overflow: scroll;
    overflow-x: hidden;
  }

  ::-webkit-scrollbar {
      width: 0px;
      background: transparent;
  }

  ::-webkit-scrollbar-thumb {
      background: transparent;
  }

</style>
