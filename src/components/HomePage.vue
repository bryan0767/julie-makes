<template>
  <div id="rootHomePageGrid" :style="{background:`url('${data.heroimage}') center/cover no-repeat`}">
    <v-row id="homePageHeaderGrid" dense>
      <v-col cols="12" class="text-h4 text-sm-h3 text-center mainHeader animateHeader">{{ data.header }}</v-col>
      <v-col cols="12" class="text-caption text-sm-body-2 text-center mainDescription animateHeader">
        {{ data.description }}
      </v-col>
      <v-col cols="10" id="homePageHeaderDivider"></v-col>
      <v-col cols="12" id="homePageHeaderIconGrid">
        <v-row style="width:70%;margin:0 auto" justify="space-around">
          <v-icon v-for="icon in data.icons" :class="icon.className">{{ icon.src }}</v-icon>
        </v-row>
      </v-col>
    </v-row>
  </div>
</template>
<script>

  import { TweenMax, TimelineMax } from "gsap"

  export default {
    name: "HomePage",
    components: {},
    props: [ "data" ],
    mounted: function() {
      this.addMainTimeline();
    },
    methods: {
      addMainTimeline() {
        let timeline = new TimelineMax({ paused:true });

        timeline.staggerFromTo( $('.animateHeader') , .75,  { opacity: 0, transform: 'translateY(100px)' }, { opacity: 1, transform:'translateY(0)' }, 1)
                .from("#homePageHeaderDivider", .75, { flex: '0 0 1%'})
                .staggerFromTo($('.iconColor'), .75, { opacity:0}, { opacity: 1 }, .25)
                .play()
                .eventCallback("onComplete", () => {
                  this.$store.commit("Home/showFab", true)
                })

      }
    }
  }

</script>

<style lang="scss">

  .iconColor {
    // color:#d5d5d5 !important;
    color:black !important;
  }

  .animateHeader {
    // color:#d5d5d5;
    color:black !important;
    opacity:0;
    position:relative;
  }

  #rootHomePageGrid {
    height:100vh;
    width:100vw;
    position:relative;
    background-attachment: fixed !important;
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
      // background:#cbc9c9;
      background:black;
      height:3px;
      margin:20px auto;
      padding:0;
  }

  @media (max-width: 599px) {

    #rootHomePageGrid {
      background-attachment: scroll;
    }

  }

</style>
