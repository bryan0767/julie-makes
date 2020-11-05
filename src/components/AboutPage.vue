<template>
    <div id="rootAboutPage">
      <v-row justify="center" align="center" class="aboutHeaderRow">
        <v-col xs="2" sm="2" class="portfolioSeperator"></v-col>
        <v-col xs="8" sm="2" class="text-h5 text-center mainText">{{ data['header'] }}</v-col>
        <v-col xs="2" sm="8" class="portfolioSeperator"></v-col>
      </v-row>
      <v-row align="start" style="width:90%;margin:0px auto">
        <v-col cols="12" xs="12" sm="6" class="d-flex justify-start">
          <div id="aboutImagesContainer">
            <div v-if="mainImage" id="aboutImage" :style="{background:`url('${mainImage}') center/cover no-repeat`}"></div>
            <v-row style="height:75px;" v-if="images.length">
              <v-col v-for="( image, ind ) in images" @click="updateImage( $event, image, ind )" :style="{background:`url('${image}') center/cover no-repeat`}"></v-col>
            </v-row>
          </div>
        </v-col>
        <v-col cols="12" xs="12" sm="6" class="d-flex justify-end">
          <div id="aboutDescription" class="text-body-2"> {{ data.description }} </div>
        </v-col>
      </v-row>
    </div>
</template>

<style>
  #rootAboutPage {
    width:100vw;
    max-width:1100px;
    padding:50px 0 0;
    margin:0 auto;
  }

  .portfolioSeperator {
    height:2px;
    max-height:2px;
    background:grey;
    opacity:.5;
  }

  .aboutHeaderRow {
    width:90%;
    margin:0px auto 50px !important;
  }

  #aboutImage {
    height:350px;
    width:100%;
    margin:10px auto;
    transition: all .5s ease-in;
  }

  #aboutImagesContainer {
    width:90%;
    max-width:600px;
    margin: 0 auto;
  }

  #aboutDescription {
    width:100%;
    max-width:600px;
    max-height:500px;
    overflow:scroll;
  }

  @media (max-width: 599px) {

    #aboutDescription {
      text-align:center;
      max-height: none;
    }

    .portfolioSeperator {
      display:none;
    }

    .aboutHeaderRow {
      margin: 0 auto 20px !important;
    }

  }

</style>

<script>

  import ScrollMagic from "scrollmagic"
  import { TweenMax, TimelineMax } from "gsap"

  export default {
    name:"AboutPage",
    props:["data"],
    created: function() {
      this.images = this.data.images.map(x => x.src)
      this.mainImage = this.data.heroimage
    },
    mounted: function() {
      this.addMainScene()
    },
    data() {
      return {
        images: [],
        mainImage: "",
      }
    },
    methods: {
      updateImage( e, image, ind ) {
        this.images[ind] = this.mainImage
        this.mainImage = image
      },
      addMainScene() {
        console.log('here being reached in add main scene')
        let timeline = new TimelineMax()
        let sepTween = TweenMax.staggerFrom( ".portfolioSeperator", 1, { flex:'0 0 1%' } )
        let mainTextTween = TweenMax.from(".mainText", 1, { opacity: 0 })
        let aboutImagesTween = TweenMax.fromTo("#aboutImagesContainer", 1, { opacity: 0, transform:"translateY(100px)" }, { opacity: 1, transform:"translateY(0px)" })
        let aboutDescriptionTween = TweenMax.fromTo("#aboutDescription", 1, { opacity: 0, transform:"translateX(100px)" }, { opacity: 1, transform:"translateX(0px)" })

        timeline.add(sepTween, 0).add(mainTextTween, 0).add(aboutImagesTween).add(aboutDescriptionTween)

        let mainAboutScene = new ScrollMagic.Scene({
          triggerElement: $("#rootAboutPage")[0],
          offset: -50,
          duration: 350
        }).setTween(timeline)
        this.$store.dispatch("Scroll/addScene", mainAboutScene)
      }
    },
    computed: {

    }
  }
</script>
