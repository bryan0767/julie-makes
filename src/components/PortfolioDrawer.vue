<template>
  <div>
    <md-drawer :md-active="true" :md-right="true" class="rootDrawer">
      <div class="md-layout itemsGrid">
        <div v-for="item in $store.state.Portfolio.items" class="md-layout-item md-size-50 md-xsmall-size-100" style="margin:20px 0">
          <div class="md-title">{{ item.title }}</div>
          <img :src="item.media" style="width:90%;margin:15px 0" />
          <div class="md-subtitle">{{ item.date }}</div>
        </div>
      </div>
    </md-drawer>
  </div>
</template>

<style lang="scss" scoped>

  .rootDrawer {
    width:40%;
    background-color:#fffcce;
    transform: translate3d(100%, 0, 0);
    transition-timing-function: ease-in;
    overflow:hidden;
 }

  .itemsGrid {
    padding:20px;
    text-align: center;
  }


</style>

<script>
  import ScrollMagic from 'scrollmagic'

  export default {
    name:"PortfolioDrawer",
    mounted: function(){

      let drawer = document.querySelector(".rootDrawer")

      let drawerToggleScene = new ScrollMagic.Scene({
                                duration: 400, // how long it takes while scrolling to open
                                triggerElement:"#rootGrid",
                                offset:500
                              }).setTween(".rootDrawer", 10, {
                                  transform: "translate3d(0%, 0, 0)"
                              }).on("start", (e) => {
                                this.addReverseScene()
                                if(e.scrollDirection == "REVERSE") {
                                  this.$store.commit("Portfolio/setDrawerOpen", false)
                                }
                              }).on("end", (e) => {
                                if(e.scrollDirection == "FORWARD") {
                                  this.$store.commit("Portfolio/setDrawerOpen", true)
                                }
                              })

      this.$store.dispatch("Scroll/addScene", drawerToggleScene)

    },
    methods: {
      addReverseScene() {
        let drawer = document.querySelector(".rootDrawer")
        let reverseToggleScene = new ScrollMagic.Scene({
                                      duration: 400,
                                      triggerElement:"#rootGrid",
                                      offset: drawer.scrollHeight + drawer.clientHeight
                                    }).setTween(".rootDrawer", 10, {
                                        transform: "translate3d(100%, 0, 0)"
                                    }).on("start", (e) => {
                                      if(e.scrollDirection == "REVERSE") {
                                        this.$store.commit("Portfolio/setDrawerOpen", true)
                                        this.$store.commit("Contact/toggleOpen", false)
                                      }
                                    }).on("end", (e) => {
                                      if(e.scrollDirection == "FORWARD") {
                                        this.$store.commit("Portfolio/setDrawerOpen", false)
                                        this.$store.commit("Contact/toggleOpen", true)
                                      }
                                    })

        if(this.$store.state.Portfolio.addReverseScene) {
            this.$store.dispatch("Scroll/addScene", reverseToggleScene)
        }

    }
  }
}
</script>
