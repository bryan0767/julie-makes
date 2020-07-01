<template>
  <div id="rootGrid">
    <div id="heroGrid">
      <Header />
      <PortfolioDrawer />
      <ContactDrawer />
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
import ContactDrawer from "./ContactDrawer.vue"

  export default {
    name: "App",
    components: {
      Header,
      PortfolioDrawer,
      ContactDrawer
    },
    data(){
      return {
        lastPos:0,
        newPos:0
      }
    },
    methods: {
      checkScrollValues(settings) {

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
      let root = document.querySelector("#rootGrid")
      let scene = new ScrollMagic.Scene({
                            	duration: root.clientHeight + root.scrollHeight
                            }).setPin('#heroGrid')
                              .on("progress", (e) => {
                                this.checkScrollValues()

                                let drawer = document.querySelector(".rootDrawer")
                                let endReached = drawer.scrollHeight - Math.floor(drawer.scrollTop) <= drawer.clientHeight
                                let windowScroll = drawer.scrollHeight >= window.scrollY
                                let { newPos, lastPos, position } = this.$store.state.Scroll
                                let { portfolioOpen } = this.$store.state.Portfolio

                                if( !this.$store.state.Portfolio.addReverseScene && e.progress > 0 ) {
                                  $(root).height(root.clientHeight + root.scrollHeight)
                                  this.$store.commit("Portfolio/addReverseScene", true)
                                }

                                if( endReached ) {
                                  if( e.scrollDirection == 'REVERSE' && portfolioOpen && windowScroll ) {
                                    this.$store.commit("Scroll/scrollDrawer", {
                                      value: newPos - lastPos
                                    })

                                    $(drawer).animate({
                                      scrollTop: parseFloat( this.$store.state.Scroll.position.toFixed(1) )
                                    },{
                                      easing:"linear",
                                      duration:5
                                    })
                                  }

                                } else {

                                  if(e.scrollDirection == "REVERSE") {
                                    this.$store.commit("Scroll/scrollDrawer", {
                                      value: newPos - lastPos
                                    })
                                  } else {
                                    if(e.progress > .15) {
                                        this.$store.commit("Scroll/scrollDrawer", {
                                          value: newPos - lastPos
                                        })
                                    }
                                  }
                                  $(drawer).animate({
                                    scrollTop: parseFloat( this.$store.state.Scroll.position.toFixed(1) )
                                  }, {
                                    easing:"linear",
                                    duration:5
                                  })
                                }
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
