<template>
    <v-row id="rootPortfolioGrid">
      <v-col cols="3" class="sidePortfolio">
          <div class="blurOverlay"></div>
          <div class="contactImage"></div>
          <v-col cols="10" class="bottomDescription justify-center text-center">
            <div class="text-subtitle-1 iconColor" style="margin:20px auto 0;">Juliana Atencia</div>
            <div class="text-caption font-italic text-center iconColor" style="margin:10px auto 20px;">Life is to be lived, not controlled; and humanity is won by continuing to play in face of certain defeat.</div>
            <div class="d-flex justify-space-around" style="width:75%;margin:0 auto;">
              <v-icon class="iconColor">mdi-facebook</v-icon>
              <v-icon class="iconColor">mdi-instagram</v-icon>
              <v-icon class="iconColor">mdi-linkedin</v-icon>
              <v-icon class="iconColor">mdi-mail</v-icon>
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
      <v-col cols="9" id="portfolioItemContainer">
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
  }

  .contactImage {
    height:200px;
    width:200px;
    border-radius:50%;
    margin:40px auto 0;
    background:url('https://pkimgcdn.peekyou.com/0f91777bce73cf296b28e66095fde798.jpeg') center/cover no-repeat
  }

  .bottomDescription {
    margin:0 auto;
  }

  .sidePortfolio {
    /* background:url("https://c.wallhere.com/photos/fe/65/tunnel_underground_lights_architecture_photography-56850.jpg!d") center / cover no-repeat; */
    background: #394d39ad;
    max-height:100vh;
    border-radius:0px;
    position:relative;
  }

  .blurOverlay {
    height: 100vh;
    width: 25vw;
    position:absolute;
    filter: blur(1000px);
    z-index: 999;
    background: #394d39a3;
  }

  .icon {
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
      .portfolioItem {
        width:min-content;
        flex:initial;
        padding:20px;
        border:.2px solid #e8e8e8;
        background:white;
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

</style>

<script>
  export default {
    name:"PortfolioPage"
  }
</script>
