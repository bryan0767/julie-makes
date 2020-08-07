<template>
  <div id="rootHomePageGrid">
    <div id="blurOverlay"></div>
    <div id="homePageHeaderGrid">
      <div class="md-display-3"  style="text-align:center;margin:20px 0;color:#d5d5d5">Juliana Atencia</div>
      <div class="md-body-1" style="text-align:center;color:#d5d5d5">
        American novelist, literary critic, and scholar best known for his novel Invisible Man,
        which won the National Book Award in 1953.
        He also wrote Shadow and Act, a collection of political,
        social and critical essays, and Going to the Territory.
      </div>
      <div id="homePageHeaderDivider"></div>
      <div id="homePageHeaderIconGrid" class="md-layout" style="color:#d5d5d5">
        <md-icon class="md-size-2x" style="color:#d5d5d5">facebook</md-icon>
        <!-- <img style="width:10%;opacity:.6" src="https://upload.wikimedia.org/wikipedia/commons/6/6e/Instagram_font_awesome.svg"/> -->
        <md-icon class="md-size-2x" style="color:#d5d5d5">instagram</md-icon>
        <md-icon class="md-size-2x" style="color:#d5d5d5">mail</md-icon>
      </div>
    </div>
  </div>
</template>

<style lang="scss">
  #rootHomePageGrid {
    height:100vh;
    width:100vw;
    border:2px solid;
    position:relative;
    background: url("https://c.wallhere.com/photos/5a/a4/black_blackandwhite_bw_monochrome_white_woman_women_lady-506390.jpg!d") center/cover no-repeat;
  }

  #blurOverlay {
    height: 100vh;
    width: 100vw;
    filter: blur(1000px);
    z-index: 1;
    background: #394d39ad;
  }

  #homePageHeaderGrid {
    max-width:500px;
    position:absolute;
    margin:0 auto;
    transform:translate(-50%, -50%);
    top:50%;
    left:50%;
  }

  #homePageHeaderDivider {
      width:100%;
      background:#cbc9c9;
      height:3px;
      margin:20px 0
  }

</style>

<script>
import ScrollMagic from "scrollmagic"


  export default {
    name: "HomePage",
    components: {},
    data(){
      return {}
    },
    mounted: function() {},
    methods: {}
  }

</script>
