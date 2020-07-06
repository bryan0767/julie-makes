<template>
  <div id="headerRootGrid">
    <div id="headerGrid">
      <div class="md-display-3 variantColor" id="headerTitle">Julie Atencia</div>
      <div class="md-layout md-alignment-center-center" id="bottomTextGrid">
        <div class="md-layout-item md-title variantColor">Portfolio</div>
        <div class="md-layout-item md-title variantColor">About</div>
        <div class="md-layout-item md-title variantColor">Contact</div>
      </div>
    </div>
  </div>
</template>

<style>
  #headerRootGrid {
    position:absolute;
    width:100vw;
    height:100vh;
  }
  #headerGrid {
    width:350px;
    position:absolute;
    bottom: 25%;
    right:10%;
  }
  #bottomTextGrid {
    text-align:center;
    margin:15px 0;
  }

  .variantColor {
      /* color: #ffeec7; */
      color:black;
  }

</style>

<script>
  import ScrollMagic from "scrollmagic"

  export default {
    name:"Header",
    mounted: function(){

      let bottomTextScene = new ScrollMagic.Scene({
                              duration: 500,
                              triggerElement:"#heroGrid",
                              offset:500
                            }).setTween("#headerGrid", 2, {
                              rotate: "-90deg",
                              right:"40%"
                            })

      let bottomHeaderScene = new ScrollMagic.Scene({
                              duration: 500,
                              triggerElement:"#heroGrid",
                              offset:500
                            }).setTween("#headerTitle", 2, {
                              opacity:"0",
                              display:"none"
                            })

      this.$store.dispatch("Scroll/addScene", bottomTextScene)
      this.$store.dispatch("Scroll/addScene", bottomHeaderScene)
    }
  }
</script>
