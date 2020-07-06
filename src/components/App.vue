<template>
  <div id="rootGrid">
    <div id="heroGrid">
      <Header />
      <PortfolioDrawer />
      <AboutDrawer />
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
    overflow:hidden;
      .md-overlay {
        display:none;
      }
  }

</style>

<script>
import ScrollMagic from "scrollmagic"

import Header from "./Header.vue"
import PortfolioDrawer from "./PortfolioDrawer.vue"
import AboutDrawer from "./AboutDrawer.vue"

  export default {
    name: "App",
    components: {
      Header,
      PortfolioDrawer,
      AboutDrawer
    },
    data(){
      return {}
    },
    methods: {
      checkScrollValues(settings) {

        // will scroll the divs based on user scroll speeds

        this.$store.commit("Scroll/changePos", {
          key:"lastPos",
          value: this.$store.state.Scroll.newPos,
        })

        this.$store.commit("Scroll/changePos", {
          key:"newPos",
          value: window.scrollY
        })

      }
    },
    mounted: function() {

      // main grid
      let root = document.querySelector("#rootGrid")

      // portfolio drawer
      let portfolioDrawer = document.querySelector(".portfolioDrawer")
      // the end of the portfolio drawer
      // let endReached = portfolioDrawer.scrollHeight - Math.floor(portfolioDrawer.scrollTop) <= portfolioDrawer.clientHeight
      // checks if user has scrolled past drawer completely
      // let portfolioDrawerScroll = portfolioDrawer.scrollHeight >= window.scrollY

      // about drawer
      let aboutDrawer = document.querySelector(".rootAboutDrawer")
      // the end of the about drawer
      // let aboutDrawerEndReached = aboutDrawer.scrollHeight - Math.floor(aboutDrawer.scrollTop) <= aboutDrawer.clientHeight
      // checks if user has scrolled past drawer completely
      // let aboutScroll = aboutDrawer.scrollHeight >= window.scrollY

      let aboutScene = new ScrollMagic.Scene({
        duration: 600,
        triggerElement:"#rootGrid",
        offset: portfolioDrawer.scrollHeight + portfolioDrawer.clientHeight + 200
      }).setTween(aboutDrawer, 2, {
          transform: "translate3d(0, 30%, 0)",
          opacity:"1"
      }).on("end", (e) => {
        if(e.scrollDirection == 'FORWARD') {
          this.$store.commit("About/toggleOpen", true)
        } else {
          this.$store.commit("About/toggleOpen", false)
        }
      });

      let newHeaderScene = new ScrollMagic.Scene({
        duration: 500,
        triggerElement:"#rootGrid",
        offset: portfolioDrawer.scrollHeight + portfolioDrawer.clientHeight + 500
      }).setTween("#headerGrid", 10, {
          rotate: "0deg",
          top:"20%",
          right:"10%"
        })

      this.$store.dispatch("Scroll/addScene", aboutScene)
      this.$store.dispatch("Scroll/addScene", newHeaderScene)

      let scene = new ScrollMagic.Scene({
                            	duration: root.clientHeight + root.scrollHeight
                            }).setPin('#heroGrid')
                              .on("progress", (e) => {
                                this.checkScrollValues()

                                let { newPos, lastPos, position } = this.$store.state.Scroll
                                let { portfolioOpen } = this.$store.state.Portfolio
                                let { aboutOpen } = this.$store.state.About

                                if( !this.$store.state.Portfolio.addReverseScene && e.progress > 0 ) {
                                  // adds reverse scene to portfolio in store
                                  $(root).height(root.clientHeight + root.scrollHeight)
                                  this.$store.commit("Portfolio/addReverseScene", true)
                                }

                                // if( endReached ) {
                                  // if the end of the portfolio drawer is reached
                                  // console.log('the end is reached')
                                  // if( e.scrollDirection == 'REVERSE' && portfolioOpen && portfolioDrawerScroll ) {
                                  //   console.log('here', portfolioOpen)
                                  //   // this.$store.commit("Scroll/scrollDrawer", {
                                  //   //   value: newPos - lastPos
                                  //   // })
                                  //   //
                                  //   // $(portfolioDrawer).animate({
                                  //   //   scrollTop: parseFloat( this.$store.state.Scroll.position.toFixed(1) )
                                  //   // },{
                                  //   //   easing:"linear",
                                  //   //   duration:5
                                  //   // })
                                  // } else {
                                  //   // console.log(aboutOpen)
                                  //   if(aboutOpen) {
                                  //     console.log("here in the if")
                                  //     $(aboutDrawer).animate({
                                  //       scrollTop: aboutDrawer.scrollTop += ( newPos - lastPos )
                                  //     }, {
                                  //       easing:"linear",
                                  //       duration:5
                                  //     })
                                  //   }
                                  //   // about me drawer
                                  //
                                  //   this.$store.commit("Scroll/scrollDrawer", {
                                  //     value: newPos - lastPos
                                  //   })
                                  // }

                                // } else {
                                  // if the end of the portfolio drawer has not been reached
                                  if(e.scrollDirection == "REVERSE") {
                                    this.$store.commit("Scroll/scrollDrawer", {
                                      value: newPos - lastPos
                                    })
                                  } else {
                                    if(e.progress > .10) {
                                        this.$store.commit("Scroll/scrollDrawer", {
                                          value: newPos - lastPos
                                        })
                                    }
                                  }

                                  $(portfolioDrawer).animate({
                                    scrollTop: parseFloat( this.$store.state.Scroll.position.toFixed(1) )
                                  }, {
                                    easing:"linear",
                                    duration:5
                                  })
                                // }
                              })

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
