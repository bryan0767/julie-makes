<template>
    <div class="mobileToolbar">
      <div>Home</div>
      <div>Portfolio</div>
      <div>About</div>
      <div>Contact</div>
    </div>
</template>

<style lang="scss">

  body {
    background: white
  }

  .mobileToolbar {
    position:fixed;
    height:50px;
    width:100%;
    color:#ffeec7;
    z-index: 99999;
    transform: translate(0px, -50px);
    display:flex;
    justify-content:space-around;
    align-items: center;
  }

</style>

<script>
import ScrollMagic from "scrollmagic"

  export default {
    name: "mobileToolbar",
    data(){ return {} },
    mounted: function() {},
    methods: {}
  }

</script>
