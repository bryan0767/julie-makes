<template>
  <div id="rootAboutPage">
    <div class="md-layout md-alignment-center-center" style="max-width:80vw;margin:50px auto 0px;">
      <div class="md-layout-item md-size-40 portfolioSeperator"></div>
      <div class="md-layout-item md-size-20 md-display-1" style="text-align:center">About Me</div>
      <div class="md-layout-item md-size-40 portfolioSeperator"></div>
    </div>
    <div id="aboutPageContainer" class="md-layout">
      <div class="md-layout-item md-size-40" id="aboutContact">
        <div class="contactImage" style="background:url('https://pkimgcdn.peekyou.com/0f91777bce73cf296b28e66095fde798.jpeg') center/cover no-repeat"></div>
        <div class="bottomDescription" style="width:70%;margin:0 auto;text-align:center">
          <div class="md-caption" style="margin:20px 0;font-style:italic;">Life is to be lived, not controlled; and humanity is won by continuing to play in face of certain defeat.</div>
          <div class="md-layout" style="width:90%;margin:0 auto">
            <md-icon class="md-layout-item">facebook</md-icon>
            <md-icon class="md-layout-item">instagram</md-icon>
            <md-icon class="md-layout-item">mail</md-icon>
            <md-icon class="md-layout-item">thumb_up</md-icon>
          </div>
        </div>
      </div>
      <div class="md-layout md-alignment-top-center md-layout-item md-size-60" id="aboutDescription" style="padding:40px 0">
        <div class="md-layout-item md-size-70" id="innerAboutDescription">
            <p>
              Lorem ipsum dolor sit amet, consectetur adipisicing elit,
              sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
              Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi
              ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
              <br>
              <br>
              Lorem ipsum dolor sit amet, consectetur adipisicing elit,
              sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
              Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi
              ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
              <br>
              <br>
              Lorem ipsum dolor sit amet, consectetur adipisicing elit,
              sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
              Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi
              ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
            </p>
        </div>
      </div>
    </div>
  </div>
</template>

<style>
  #rootAboutPage {
    height:100vh;
    width:100vw;
    border: 2px solid;
  }

  .portfolioSeperator {
    height:2px;
    background:grey;
    opacity:.5;
  }

  #aboutPageContainer {
    width:90vw;
    height:90vh;
    margin: 0 auto;
  }

  .contactImage {
    height:200px;
    width:200px;
    border-radius:50%;
    margin:40px auto 0
  }

  #aboutContact {
    /* border:1px solid; */
    height:100%;
  }

  #aboutDescription {
    /* border:1px solid pink; */
    height:100%
  }
</style>

<script>
  export default {
    name:"AboutPage",
    mounted: function() {
      console.log('here')
    }
  }
</script>
