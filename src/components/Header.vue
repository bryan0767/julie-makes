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
    width:70%;
    left:50%;
    bottom:25%;
    transform:translateX(-50%);
    max-width:1180px;
    width:100%;
    padding: 0 40px;
  }
  #headerGrid {
    width:fit-content;
    float:right
  }
  #bottomTextGrid {
    text-align:center;
    margin:15px 0
  }

  .variantColor {
      color: #ffeec7 !important;
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
                            }).setTween("#bottomTextGrid", 2, {
                              rotate: "-90deg",
                              transform:`translateX(-20vw)`
                            })

      let bottomHeaderScene = new ScrollMagic.Scene({
                              duration: 500,
                              triggerElement:"#heroGrid",
                              offset:500
                            }).setTween("#headerTitle", 2, {
                              opacity:"0"
                            })

      this.$store.dispatch("Scroll/addScene", bottomTextScene)
      this.$store.dispatch("Scroll/addScene", bottomHeaderScene)
    }
  }
</script>
