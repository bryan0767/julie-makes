<template>
  <div id="headerRootGrid">
    <div id="headerGrid">
      <div class="md-display-3" id="headerTitle">Julie Atencia</div>
      <div class="md-layout" id="progressBar" @click="changeProgress" @mouseleave="leaveTooltip" @mousemove="mouseMoving">
        <div id="progressFill"></div>
      </div>
      <div id="toolTip">{{ location }}</div>
    </div>
  </div>
</template>

<style>
  #headerRootGrid {
    position:absolute;
    width: 100vw;
    height: 100vh;
  }

  #headerGrid {
    position:absolute;
    width:100%;
    text-align: center;
    top:7%;
    display:flex;
    align-items:center;
    flex-direction:column;
    height:200px
  }

  #headerTitle {
    color:white !important;
  }

  #progressBar {
    height: 100vh;
    width: 10px;
    background: white;
    position: relative;
    overflow: hidden;
    cursor: pointer;
    z-index: 999999;
    position: fixed;
    right: 0;
    top: 0;
  }

  #progressFill {
    background:#00ffb596;
    width:100%;
    transition: width .2s ease-in
  }

  #toolTip {
    height:25px;
    width:100px;
    border-radius:50px;
    position:absolute;
    opacity:0;
    top:60%;
    display:flex;
    align-items:center;
    justify-content:center;
    color:white;
    /* background:#0000ff96; */
    transition: opacity .3s ease-in;
  }

</style>

<script>
  import ScrollMagic from "scrollmagic"

  export default {
    name:"Header",
    data() {
      return {
          location:"Home"
      }
    },
    methods: {
      changeProgress(e) {
        let mousePos = e.offsetX;
        let width = $("#progressBar").width();
        let fillWidth = ((mousePos / width).toFixed(2) * 100)
        $("#progressFill").css("width", `${fillWidth}%`)
        let newPos;
        if(fillWidth >= 0 && fillWidth <= 25 ) newPos = 0
        if(fillWidth >= 25 && fillWidth <= 50 ) newPos = $(window).height() + 250
        if(fillWidth >= 50 && fillWidth <= 75 ) newPos =( $(window).height() * 2) + 250
        if(fillWidth >= 75 && fillWidth <= 100 ) newPos = ($(window).height() * 3) + 250

        $(window).scrollTop( newPos, 0 )
      },
      mouseMoving(e) {
        let mousePos = e.offsetX;
        let width = $("#progressBar").width();
        let fillWidth = ((mousePos / width).toFixed(2) * 100)

        if(fillWidth >= 0 && fillWidth <= 25 ) this.location = "Home"
        if(fillWidth >= 25 && fillWidth <= 50 ) this.location = "Portfolio"
        if(fillWidth >= 50 && fillWidth <= 75 ) this.location = "About"
        if(fillWidth >= 75 && fillWidth <= 100 ) this.location = "Contact"

        $("#toolTip").css({
          left: e.x - 50,
          opacity:1
        })
      },
      leaveTooltip() {
        $("#toolTip").css("opacity", 0)
      },
      moveApp(type) {
        let {
          Scroll: { root, portfolioDrawer, aboutDrawer, contactDrawer }
         } = this.$store.state

        let {
               portfolioDrawer: { scrollHeight: pSHeight, clientHeight: pCHeight },
               aboutDrawer: { scrollHeight: aSHeight, clientHeight: aCHeight },
               contactDrawer: { scrollHeight: cSHeight, clientHeight: cCHeight }
             } = this.$store.state.Scroll

         switch(type) {
           case "portfolio":
             window.scrollTo({
               top: $(window).height() / 2,
               left: 0,
               behavior: "smooth"
             })
             break;
           case "about":
             window.scrollTo({
               top: portfolioDrawer.scrollHeight + portfolioDrawer.clientHeight,
               left: 0,
               behavior: "smooth"
             })
             break;
           case "contact":
             window.scrollTo({
               top: pSHeight + pCHeight + aSHeight + aCHeight + $(window).height(),
               left: 0,
               behavior: "smooth"
             })
             break;
           default:
            console.log("defaulting")
            window.scrollTo({
              top: 0,
              left: 0,
              behavior: "smooth"
            })
         }

      }
    }
  }
</script>
