<template>
  <v-app id="rootGrid">
    <!-- <ProgressBar /> -->

      <HomePage />
      <PortfolioPage />
      <AboutPage />
      <ContactPage />

  </v-app>
</template>

<style lang="scss">

  #app {
    overflow: hidden;
  }

  .col {
    padding:0;
  }

  .row {
    margin-right:0;
    margin-left:0;
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

  #imageGrid {
    background: url("https://images.pexels.com/photos/374684/pexels-photo-374684.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=1100") center/cover no-repeat;
  }

  #imageGridPort {
    background: url("https://c.wallhere.com/photos/5a/a4/black_blackandwhite_bw_monochrome_white_woman_women_lady-506390.jpg") center/cover no-repeat;
    opacity:.5;
  }

  #imageGridAbout {
    background: url("https://tr4.cbsistatic.com/hub/i/r/2020/04/21/92fefa52-5abd-4cb6-88ad-f440a9952a8b/resize/1200x900/159117c93c0182e2d4d4f279b3fbbc40/ca-9.jpg") center/cover no-repeat;
  }

  #imageGridContact {
    background: url("https://wallpaperaccess.com/full/547232.jpg") center/cover no-repeat;
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

</style>

<script>
import ScrollMagic from "scrollmagic"

import ProgressBar from "./ProgressBar.vue"
import HomePage from "./HomePage.vue"
import AboutPage from "./AboutPage.vue"
import ContactPage from "./ContactPage.vue"
import PortfolioPage from "./PortfolioPage.vue"
import PortfolioPageMobile from "./PortfolioPageMobile.vue"


  export default {
    name: "App",
    components: {
      ProgressBar,
      HomePage,
      AboutPage,
      ContactPage,
      PortfolioPage,
      PortfolioPageMobile
    },
    data(){
      return {
        mountHeader: false,
        mountAboutDrawer:false,
        mountContactDrawer:false,
        scrollProps: {
          easing:"linear",
          duration: 5
        }
      }
    },
    mounted: function() {
      //
      // this.$store.commit("Scroll/setElements", [
      //   { key:"root", value: document.querySelector("#rootGrid") },
      //   { key:"portfolioDrawer", value: document.querySelector(".portfolioDrawer") }
      // ])
      //
      // this.mountAboutDrawer = true
      // this.mountContactDrawer = true
      // this.mountHeader = true
      //
      // let { root } = this.$store.state.Scroll
      //
      // $( root ).css( 'height', $(window).height() * 5 )
      // let scene = new ScrollMagic.Scene({
      //                       	duration: ( $(root).height() - $(window).height() )
      //                       }).setPin('#heroGrid')
      //                         .on("progress", (e) => {
      //                           $("#progressFill").css("height", `${(e.progress).toFixed(2) * 100}%` )
      //                           this.$store.commit("Scroll/changeProgress", e.progress)
      //                           let toolbar = document.querySelector(".mobileToolbar");
      //
      //                           this.checkScrollValues()
      //
      //                           let {
      //                             About: { aboutOpen },
      //                             Contact: { contactOpen },
      //                             Portfolio: { portfolioOpen, addReverseScene },
      //                             Scroll: { root,
      //                                       newPos,
      //                                       lastPos,
      //                                       position,
      //                                       aboutPosition,
      //                                       contactPosition,
      //                                       portfolioDrawer,
      //                                       aboutDrawer,
      //                                       contactDrawer }
      //                           } = this.$store.state
      //                         })
      //
      // this.$store.dispatch("Scroll/addScene", scene)

    },
    methods: {
      mobile() {
        return $(window).width() <= 599
      },
      checkScrollValues(settings) {
        this.$store.commit("Scroll/changePos", {
          key:"lastPos",
          value: this.$store.state.Scroll.newPos,
        })

        this.$store.commit("Scroll/changePos", {
          key:"newPos",
          value: window.scrollY
        })
      },
      animateDrawer( open, e, progress, position, el, value ) {
        let { newPos, lastPos } = this.$store.state.Scroll
        if( open ) {
          if( e.progress > progress ) {
            this.$store.commit("Scroll/scrollDrawer", { key: position, value: newPos - lastPos })
          } else {
              if( e.scrollDirection == "REVERSE" ) {
                this.$store.commit("Scroll/scrollDrawer", { key: position, value: newPos - lastPos })
              }
          }
        }

        $(el).animate({
          scrollTop: parseFloat( value.toFixed(1) )
        }, this.scrollProps)
      }
    },
  }

</script>
