<template>
  <div id="rootGrid">
    <div id="heroGrid">
      <Header />
      <!-- <PortfolioDrawer /> -->
    </div>
  </div>
</template>

<style lang="scss">
  body {
      background:black
  }

  #heroGrid {
    background: url("https://images.unsplash.com/photo-1500964757637-c85e8a162699?ixlib=rb-1.2.1&q=80&fm=jpg&crop=entropy&cs=tinysrgb") center/cover no-repeat;
    height:100vh;
    width:100vw;
    position:absolute;
  }
  #rootGrid {
    height:500vh;
    width:100vw;
    position:relative;
  }
</style>

<script>
import ScrollMagic from "scrollmagic"

import Header from "./Header.vue"
import PortfolioDrawer from "./PortfolioDrawer.vue"

  export default {
    name: "App",
    components: {
      Header,
      PortfolioDrawer
    },
    data(){
      return {
        name:"none",
        job:"none"
      }
    },
    mounted: function() {

      let scene = new ScrollMagic.Scene({
                            	duration: 5000,
                            }).setPin('#heroGrid')

      this.$store.dispatch("Scroll/addScene", scene)


      // fetch("/getAll")
      //       .then(x => x.json())
      //       .then(y => {
      //         this.name = y.name;
      //         this.job = y.job
      //       })

    }
  }

</script>
