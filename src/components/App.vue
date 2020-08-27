<template>
  <v-app id="rootGrid">
      <HomePage />
      <PortfolioPage />
      <AboutPage />
      <ContactPage />
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
    }
  }

</script>

<style lang="scss">

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

  @media (min-width: 2500px) {

    #app {
      height: 300vh;
    }

  }

</style>
