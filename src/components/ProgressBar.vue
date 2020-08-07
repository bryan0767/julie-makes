<template>
  <div>
    <div id="progressBar" @click="changeProgress" @mouseleave="leaveTooltip" @mousemove="mouseMoving">
      <div id="progressFill"></div>
    </div>
    <div id="toolTip">{{ location }}</div>
  </div>
</template>

<style lang="scss">

  #progressBar {
    height: 100vh;
    width: 10px;
    background: white;
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

</style>

<script>
import ScrollMagic from "scrollmagic"


  export default {
    name: "ProgressBar",
    components: {},
    data(){
      return {}
    },
    mounted: function() {},
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
    }
  }

</script>
