<template>
    <div class="portfolioDrawer">
      <div class="itemsGrid">
        <div class="innerItemsGrid" :style="{ width: innerItemsGridWidth }">
          <div v-for="item in mainData" class="md-layout innerGrid">
            <div v-for="art in item" class="md-layout-item innerGridItem" :style="{ minWidth: innerGridItemWidth }">
              <div class="demoImage"></div>
              <div class="md-subtitle caption">{{ art.date }}</div>
            </div>
          </div>
        </div>
      </div>
      <div id="selectors">
        <div v-for="( selector , ind) in selectorCount()" class="selector" @click="movePort($event, ind)"></div>
      </div>
    </div>
</template>

<style lang="scss" scoped>

  .innerGrid {
    display:flex;
    justify-content:center;
    height:100%;
    width:100vw;
  }

  .innerGridItem {
    // min-width:33%; // important
    // max-width:33%; // important
  }

  .innerItemsGrid {
    height:100%;
    width: 400vw; // important
    display:flex;
    position:relative;
  }

  .closeButton {
    position:absolute;
    right:25px;
  }

  .portfolioDrawer {
    height:100%;
    display:flex;
    justify-content: center;
    flex-direction:column;
 }

  .itemsGrid {
    text-align: center;
    height:53%;
  }

  .demoImage {
    border-radius:50%;
    background:#afafaf;
    height:150px;
    width:150px;
    margin:10px auto;
  }

  .caption {
    color:white;
  }

  #selectors {
    color:white;
    width:100%;
    text-align:center;
    display:flex;
    align-items:center;
    justify-content:center;
    position:absolute;
    bottom:8%;
    flex-flow:row wrap;
      & .active {
        background: #d99696;
      }
  }

  .selector {
    background:black;
    height:20px;
    width:20px;
    margin:20px;
    border-radius:50px;
    cursor:pointer;
    z-index: 1;
  }

  @media (max-width: 599px) {
    .portfolioDrawer {}
  }


</style>

<script>
  import ScrollMagic from 'scrollmagic'
  import { TimelineMax, TweenMax } from "gsap"

  export default {
    name:"PortfolioDrawer",
    data() {
      return {
        reverseSceneAdded: false,
        count: 6,
        mainData: [],
        val: 0,
        index: 0,
        innerItemsGridWidth: 0,
        innerGridItemWidth: 0
      }
    },
    mounted: function(){
      this.resize()
      this.addMainScene()
      this.organizeArticles()
    },
    methods: {
       getWidth(type) {
        let elWidth = $(window).width() - 100
        switch(type) {
          case "inner":
          return ( elWidth / (this.count / 2) ) * this.$store.state.Portfolio.items.length
          break;
          case "card":
          return ( elWidth / (this.count / 2) )
          break;
          default:
          return;
          break;
        }
      },
      resize() {
        let width = $(window).width();
        $("#imagesCont").animate({
          right:0
        }, 0)
        this.val = 0;

        if(width > 1200) {
          this.count = 8
          this.innerItemsGridWidth = this.getWidth("inner") + "px",
          this.innerGridItemWidth = this.getWidth("card") + "px"
        } else if (width > 630) {
          this.count = 6
          this.innerItemsGridWidth = this.getWidth("inner") + "px",
          this.innerGridItemWidth = this.getWidth("card") + "px"
        } else {
          this.count = 2
          this.innerItemsGridWidth = this.getWidth("inner") + "px",
          this.innerGridItemWidth = this.getWidth("card") + "px"
        }
      },
      movePort(e, ind) {
        let direcVal;

        if(ind == 0) {
          this.val = 0
        } else {
          direcVal = ind - this.index
          this.val = this.val += ( $( window ).width() * direcVal )
        }

        this.index = ind

        $(".innerItemsGrid").animate({
          right: this.val
        }, 500)

        let selector = document.querySelectorAll(".selector")

        Object.values(selector).forEach(x => {
          let list = Object.values(x.classList)
          if( list.includes('active') && x != e.target ) {
            x.classList.remove('active')
          }
        })

        e.target.classList.add("active")
      },
      organizeArticles() {
        let arts = this.$store.state.Portfolio.items
        let dataArray = []
        for( let x = 0; x < arts.length; x++ ) {
          if( dataArray.length == this.count ) {
            this.mainData.push(dataArray)
            dataArray = []
            dataArray.push( arts[x] )
          } else {
              dataArray.push( arts[x] )
              if( x == ( arts.length - 1 ) ) this.mainData.push( dataArray )
          }
        }
      },
      selectorCount() {
        return Math.ceil(this.$store.state.Portfolio.items.length / this.count)
      },
      addMainScene() {
        let timeline = new TimelineMax();
        let drawerTween = TweenMax.fromTo(".portfolioDrawer", 1, { opacity: 0 }, { opacity: 1 });
        let heroTween = TweenMax.fromTo("#imageGrid", 1,  { opacity: 1 }, { opacity: 0 });
        let mobileTween = TweenMax.to(".mobileToolbar", 1, { transform: "translate(0, 0)" });

        timeline.add(heroTween, 0)
                .add(drawerTween, 0)
                .add(mobileTween, 0);
        let { root } = this.$store.state.Scroll

        let drawerToggleScene = new ScrollMagic.Scene({
                                      duration: 150,
                                      offset: `${ $(window).height() }px`
                                    }).setTween(timeline)
                                      .on("start", (e) => {
                                        if( !this.reverseSceneAdded ) this.addReverseScene()
                                        this.$store.commit("About/mount", true)
                                        if(e.scrollDirection == "REVERSE") this.$store.commit("Portfolio/setDrawerOpen", false)
                                    }).on("end", (e) => {
                                        if(e.scrollDirection == "FORWARD") this.$store.commit("Portfolio/setDrawerOpen", true)
                                    }).addIndicators()

        this.$store.dispatch("Scroll/addScene", drawerToggleScene)
      },
      addReverseScene() {
        let { portfolioDrawer, root } = this.$store.state.Scroll

        let timeline = new TimelineMax();
        let drawerTween = TweenMax.to(".portfolioDrawer", 1, { opacity: 0 });

        timeline.add(drawerTween, 0)

        let reverseToggleScene = new ScrollMagic.Scene({
                                      duration: 150,
                                      offset: `${ $(window).height() * 2 }px`
                                    }).setTween(timeline)
                                      .on("start", (e) => {
                                        console.log('strting')
                                        if(e.scrollDirection == "REVERSE")
                                          this.$store.commit("Portfolio/setDrawerOpen", true)
                                    }).on("end", (e) => {
                                      console.log("ending")
                                        if(e.scrollDirection == "FORWARD")
                                          this.$store.commit("Portfolio/setDrawerOpen", false)
                                    })

          this.reverseSceneAdded = true
          this.$store.dispatch("Scroll/addScene", reverseToggleScene)
    }
  }
}
</script>
