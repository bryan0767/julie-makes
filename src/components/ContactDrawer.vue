<template>
  <div>
    <md-drawer :md-active="$store.state.Contact.contactOpen" class="rootContactDrawer">
      <div class="md-layout ContactGrid">
          <div class="md-display-4">About Me</div>
          <div class="md-display-1" style="margin:20px 0">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</div>
          <div class="md-display-1">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</div>
      </div>
    </md-drawer>
  </div>
</template>

<style lang="scss">

  .rootContactDrawer {
    width:100vw;
    height:100vh;
    max-width:100%;
    background: #fffcce;
    transition-timing-function: ease-in;
    overflow:hidden;
  }

  .ContactGrid {
    padding:50px
  }

</style>

<script>
export default {
    name:"ContactDrawer",
    mounted: function() {}
}
</script>
