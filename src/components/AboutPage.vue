<template>
    <div id="rootAboutPage">
      <v-row justify="center" align="center" class="aboutHeaderRow">
        <v-col xs="2" sm="2" class="portfolioSeperator"></v-col>
        <v-col xs="8" sm="2" class="text-h5 text-center mainText">About Me</v-col>
        <v-col xs="2" sm="8" class="portfolioSeperator"></v-col>
      </v-row>
      <v-row align="start" style="width:90%;margin:0px auto">
        <v-col cols="12" xs="12" sm="6" class="d-flex justify-start">
          <div id="aboutImagesContainer">
            <div id="aboutImage" :style="{background:`url('${mainImage}') center/cover no-repeat`}"></div>
            <v-row style="height:75px;">
              <v-col v-for="( image, ind ) in images" @click="updateImage( $event, image, ind )" :style="{background:`url('${image}') center/cover no-repeat`}"></v-col>
            </v-row>
          </div>
        </v-col>
        <v-col cols="12" xs="12" sm="6" class="d-flex justify-end">
          <div id="aboutDescription" class="text-body-2">
              <p>
                Lorem ipsum dolor sit amet, consectetur adipisicing elit,
                sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
                Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi
                ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
                <br>
                <br>
                Lorem ipsum dolor sit amet, consectetur adipisicing elit,
                sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
                Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi
                ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
                <br>
                <br>
                Lorem ipsum dolor sit amet, consectetur adipisicing elit,
                sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
                Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi
                ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
              </p>
          </div>
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
    mounted: function() {
      this.addMainScene()
    },
    data() {
      return {
        mainImage: "https://i.pinimg.com/originals/c7/35/33/c735332adc5340082464f0605404275d.jpg",
        images: [
          'https://images.squarespace-cdn.com/content/v1/53a2b3a1e4b0a5020bebe676/1405692357118-YUTZ1L8S84R6FUUKXTPT/ke17ZwdGBToddI8pDm48kA0wePVlgOGM5yNNrADThjYUqsxRUqqbr1mOJYKfIPR7LoDQ9mXPOjoJoqy81S2I8N_N4V1vUb5AoIIIbLZhVYxCRW4BPu10St3TBAUQYVKc3f5rMIUspMOT17T3MGHdS3s1KwpjdUupKJDR9JNb8i8O932tY93Uq43o4DcCmt6U/black-and-white-street-photography',
          'https://www.kirkportraitdesigns.com/wp-content/uploads/2012/06/LT-0104.jpg',
          'https://i.pinimg.com/originals/3c/39/1c/3c391cb2f528a8c19c239ffe32c761e0.jpg',
          'https://img4.goodfon.com/wallpaper/nbig/7/44/luca-foscili-nicole-simpatichnaia-devushka-shatenka-poziruet.jpg'
        ]
      }
    },
    methods: {
      updateImage( e, image, ind ) {
        this.images[ind] = this.mainImage
        this.mainImage = image
      },
      addMainScene() {
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
    }
  }
</script>
