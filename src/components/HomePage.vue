<template>
  <div id="rootHomePageGrid">
    <div id="blurOverlay"></div>
    <v-row id="homePageHeaderGrid" dense>
      <v-col cols="12" class="text-h4 text-sm-h3 text-center" style="color:#d5d5d5">Juliana Atencia</v-col>
      <v-col cols="12" class="text-caption text-sm-body-2 text-center mainDescription" style="color:#d5d5d5">
        American novelist, literary critic, and scholar best known for his novel Invisible Man,
        which won the National Book Award in 1953.
        He also wrote Shadow and Act, a collection of political,
        social and critical essays, and Going to the Territory.
      </v-col>
      <v-col cols="10" id="homePageHeaderDivider"></v-col>
      <v-col cols="12" id="homePageHeaderIconGrid">
        <v-row style="width:70%;margin:0 auto" justify="space-around">
          <v-icon class="iconColor">mdi-facebook</v-icon>
          <v-icon class="iconColor">mdi-instagram</v-icon>
          <v-icon class="iconColor">mdi-linkedin</v-icon>
          <v-icon class="iconColor">mdi-mail</v-icon>
        </v-row>
      </v-col>
    </v-row>
  </div>
</template>

<style lang="scss">

  .iconColor {
    color:#d5d5d5 !important;
  }

  #rootHomePageGrid {
    height:100vh;
    width:100vw;
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
    width:80%;
    max-width:420px;
    position:absolute;
    margin:0 auto;
    transform:translate(-50%, -50%);
    top:50%;
    left:50%;
  }

  #homePageHeaderDivider {
      background:#cbc9c9;
      height:3px;
      margin:20px auto;
      padding:0;
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
