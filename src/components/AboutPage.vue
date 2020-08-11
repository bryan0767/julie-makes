<template>
  <v-lazy>
    <div id="rootAboutPage">
      <v-row justify="center" align="center" style="width:90%;margin:0px auto 50px;">
        <v-col cols="2" class="portfolioSeperator"></v-col>
        <v-col cols="2" class="text-h5 text-center">About Me</v-col>
        <v-col cols="8" class="portfolioSeperator"></v-col>
      </v-row>
      <v-row align="center" style="width:90%;margin:0px auto">
        <v-col cols="6" class="d-flex justify-start">
          <div id="aboutImagesContainer">
            <div id="aboutImage" :style="{background:`url('${mainImage}') center/cover no-repeat`}"></div>
            <v-row style="height:75px;">
              <v-col v-for="( image, ind ) in images" @click="updateImage( $event, image, ind )" :style="{background:`url('${image}') center/cover no-repeat`}"></v-col>
            </v-row>
          </div>
        </v-col>
        <v-col cols="6" class="d-flex justify-end">
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
  </v-lazy>
</template>

<style>
  #rootAboutPage {
    height:100vh;
    width:100vw;
    max-width:1100px;
    padding:50px 0 0;
    margin:0 auto;
  }

  .portfolioSeperator {
    height:2px;
    background:grey;
    opacity:.5;
  }

  #aboutImage {
    height:350px;
    width:100%;
    margin:10px auto;
  }

  #aboutImagesContainer {
    width:90%;
    max-width:600px;
  }

  #aboutDescription {
    width:100%;
    max-width:600px;
  }
</style>

<script>
  export default {
    name:"AboutPage",
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
      }
    }
  }
</script>
