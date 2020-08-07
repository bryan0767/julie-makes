<template>
  <div id="rootPortfolioPageGrid" class="md-layout">
    <div class="md-layout md-alignment-center-center" style="max-width:80vw;margin:50px auto 0px;">
      <div class="md-layout-item md-size-40 portfolioSeperator"></div>
      <div class="md-layout-item md-size-20 md-display-1" style="text-align:center">Portfolio</div>
      <div class="md-layout-item md-size-40 portfolioSeperator"></div>
    </div>
    <div id="portfolioPageItemsContainer">
      <div id="portfolioPageInnerItemsContainer" :style="{ width:innerItemsContainerWidth }">
        <div class="innerItem" :style="{ width: innerItemWidth }" v-for="portfolioItem in $store.state.Portfolio.items">
          <div class="portfolioPageItem">
              <div class="portfolioPageItemImage" :style="{ background:`url('${portfolioItem.thumbnail}') center/cover no-repeat` }"/>
              <div class="portfolioPageItemCategory md-caption">{{ portfolioItem.category }}</div>
              <div class="portfolioPageItemHeader md-title">{{ portfolioItem.header }}</div>
              <div class="portfolioPageItemDescription">{{ portfolioItem.content }}</div>
          </div>
        </div>
      </div>
      <div id="selectors">
        <div v-for="( selector , ind) in selectorCount()" class="selector" @click="movePort($event, ind)"></div>
      </div>
    </div>
  </div>
</template>

<style>

  #rootPortfolioPageGrid {
    height:100vh;
    width:100vw;
  }

  #contactContainer {
    width:25vw;
    padding:10px 30px;
     #profileImage {
       height:150px;
       width:150px;
       border-radius:50%;
    }
  }

  .portfolioSeperator {
    height:2px;
    background:grey;
    opacity:.5;
  }

  #portfolioPageItemsContainer {
    height:100vh;
    padding:30px 0;
    
  }

  #portfolioPageInnerItemsContainer {
    display:flex;
    position:relative;
  }

  .innerItem {
    padding:20px 0;
  }

  .portfolioPageItem {
    max-width:320px;
    margin:0 auto;
  }

  .portfolioPageItemImage {
    width:320px;
    height:200px;
    border-radius:10px;
  }

  .portfolioPageItemCategory {
    margin:15px 0 5px;
  }

  .portfolioPageItemDescription {
    margin:10px 0;
  }

  #selectors {
    color:white;
    width:100vw;
    text-align:center;
    display:flex;
    align-items:center;
    justify-content:center;
    flex-flow:row wrap;
      & .active {
        background: #394d39ad;
      }
  }

  .selector {
    /* background:black; */
    border: .5px solid #394d39;
    height:20px;
    width:20px;
    margin:20px;
    border-radius:50px;
    cursor:pointer;
    z-index: 1;
  }


</style>

<script>
 export default {
   name: "PortfolioPage",
   data() {
     return {
       innerItemsContainerWidth: "",
       innerItemWidth:"",
       count: 3,
       val:0,
       index: 0
     }
   },
   mounted: function(){
     this.resize()
   },
   methods: {
     resize() {
       let width = $(window).width();
       this.val = 0;

       if(width > 1200) {
         this.count = 3
         this.innerItemsContainerWidth = this.getWidth("inner") + "px",
         this.innerItemWidth = this.getWidth("card") + "px"
       } else if (width > 630) {
         this.count = 2
         this.innerItemsContainerWidth = this.getWidth("inner") + "px",
         this.innerItemWidth = this.getWidth("card") + "px"
       } else {
         this.count = 1
         this.innerItemsContainerWidth = this.getWidth("inner") + "px",
         this.innerItemWidth = this.getWidth("card") + "px"
       }

       $("#portfolioPageInnerItemsContainer").animate({
         right: 0
       }, 500)

       let selector = document.querySelectorAll(".selector")

       Object.values(selector).forEach(x => {
         let list = Object.values(x.classList)
         if( list.includes('active') ) {
           x.classList.remove('active')
         }
       })

       Object.values(selector)[0].classList.add("active")
     },
     getWidth(type) {
      let elWidth = $(window).width()
      switch(type) {
        case "inner":
        return ( elWidth / ( this.count ) ) * this.$store.state.Portfolio.items.length
        break;
        case "card":
        return ( elWidth / ( this.count ) )
        break;
        default:
        return;
        break;
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

      $("#portfolioPageInnerItemsContainer").animate({
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
    selectorCount() {
      return Math.ceil(this.$store.state.Portfolio.items.length / this.count)
    }
   }
 }
</script>
