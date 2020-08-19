<template>
    <v-row id="rootPortfolioGrid">
      <v-col cols="3" class="sidePortfolio hidden-sm-and-down">
          <div class="contactImage"></div>
          <v-col cols="10" class="bottomDescription justify-center text-center">
            <div class="text-subtitle-1 iconColors" style="margin:20px auto 0;">Juliana Atencia</div>
            <div class="text-caption font-italic text-center iconColors" style="margin:10px auto 20px;">Life is to be lived,
              not controlled; and humanity is won by continuing to play in face of certain defeat.</div>
            <div class="d-flex justify-space-around" style="width:75%;margin:0 auto;">
              <v-icon class="iconColors">mdi-facebook</v-icon>
              <v-icon class="iconColors">mdi-instagram</v-icon>
              <v-icon class="iconColors">mdi-linkedin</v-icon>
              <v-icon class="iconColors">mdi-mail</v-icon>
            </div>
          </v-col>
          <!-- <v-expansion-panels dark>
            <v-expansion-panel>
              <v-expansion-panel-header>Filters</v-expansion-panel-header>
              <v-expansion-panel-content>
                Lorem ipsum dolor sit amet consectetur adipisicing elit. Mollitia placeat quo ratione a?
                Eaque, voluptas porro nam totam in officiis nesciunt inventore blanditiis, ut corporis saepe neque dolores aspernatur quo.
              </v-expansion-panel-content>
            </v-expansion-panel>
            <v-expansion-panel>
              <v-expansion-panel-header>Date</v-expansion-panel-header>
              <v-expansion-panel-content>
                Lorem ipsum dolor sit amet consectetur adipisicing elit. Mollitia placeat quo ratione a?
                Eaque, voluptas porro nam totam in officiis nesciunt inventore blanditiis, ut corporis saepe neque dolores aspernatur quo.
              </v-expansion-panel-content>
            </v-expansion-panel>
          </v-expansion-panels> -->
      </v-col>
      <v-col xs="12" md="9" id="portfolioItemContainer">
        <div id="portfolioInnerItemContainer" class="d-flex flex-column flex-wrap">
          <div v-for="item in $store.state.Portfolio.items" class="portfolioItem">
            <div class="portfolioItemImage" :style="{ background:`url('${item.thumbnail}') center/cover no-repeat`, position:'relative' }"></div>
            <div class="portfolioPageItemCategory text-caption">{{ item.category }}</div>
            <div class="portfolioPageItemHeader text-subtitle-2">{{ item.header }}</div>
            <div class="portfolioPageItemDescription">{{ item.content }}</div>
          </div>
        </div>
      </v-col>
    </v-row>
</template>

<style>

  #rootPortfolioGrid {
    width:100vw;
    background:#dddddd;
  }

  .contactImage {
    height:200px;
    width:200px;
    border-radius:50%;
    margin:40px auto 0;
    background:url('https://pkimgcdn.peekyou.com/0f91777bce73cf296b28e66095fde798.jpeg') center/cover no-repeat;
    position:relative;
    transition: transform .1s;
    transition-timing-function: ease-in;
  }

  .bottomDescription {
    margin:0 auto;
    position:relative;
  }

  .sidePortfolio {
    /* background:url("https://c.wallhere.com/photos/fe/65/tunnel_underground_lights_architecture_photography-56850.jpg!d") center / cover no-repeat; */
    background: #474c47;
    max-height:100vh;
    border-radius:0px;
    transition: all 0.8s ease-in-out;
  }

  .blurOverlay {
    height: 100vh;
    width: 25vw;
    position:absolute;
    filter: blur(1000px);
    z-index: 999;
    background: #394d39a3;
  }

  .iconColors {
    color:white !important;
  }

  #portfolioItemContainer {
    height:100vh;
    overflow: auto;
    background:#dddddd;
  }

  #portfolioInnerItemContainer {
    height:200vh;
    overflow-x: scroll;
    background:#dddddd;
    align-content:flex-start;
      .portfolioItem {
        width:min-content;
        flex:initial;
        padding:20px;
        border:.2px solid #e8e8e8;
        background:white;
       transition: all 0.8s ease-in-out;
      }
  }

  .portfolioItemImage {
    height:160px;
    width:240px;
    border-radius:10px;
  }

  .portfolioPageItemCategory {
    margin:15px 0 5px;
    font-size:12px;
  }

  .portfolioPageItemHeader {
    font-size:18px;
    line-height:20px;
  }

  .portfolioPageItemDescription {
    margin:5px 0;
    font-size:12px;
  }

  @media (max-width: 599px) {

    #portfolioItemContainer {
      height:initial;
    }

  }

</style>

<script>

  import ScrollMagic from "scrollmagic"
  import { TweenMax, TimelineMax } from "gsap"

  export default {
    name:"PortfolioPage",
    mounted: function() {
      this.addMainScene()
    },
    methods: {
      addMainScene() {
        let timeline = new TimelineMax()
        let sideTween = TweenMax.fromTo('.sidePortfolio', 1, { opacity: 0, transform: 'translateX(-100px)' }, { opacity: 1, transform: 'translateX(0px)' })
        let itemsTween = TweenMax.staggerFromTo($('.portfolioItem'), 1, { opacity: 0, transform: 'translateY(100px)' }, { opacity: 1,transform: 'translateY(0px)' }, .75)

        timeline.add(sideTween, 0).add(itemsTween, 0)

        let mainPortfolioScene = new ScrollMagic.Scene({
          triggerElement: $("#rootPortfolioGrid")[0],
          offset: -100,
          duration:250
        }).setTween(timeline)

        this.$store.dispatch("Scroll/addScene", mainPortfolioScene)

      }
    }
  }
</script>
