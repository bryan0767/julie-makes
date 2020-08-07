<template>
    <div class="aboutMainGrid">
      <div class="rootAbout">
            <div class="md-layout md-alignment-top-right aboutGrid">
              <div class="md-layout-item md-xsmall-size-100 md-size-60 textGrid">
                <div class="md-headline" style="margin:20px 0">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</div>
                <div class="md-headline" style="margin:20px 0">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</div>
                <div class="md-headline" style="margin:20px 0">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</div>
                <div class="md-headline" style="margin:20px 0">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</div>
                <div class="md-headline" style="margin:20px 0">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</div>
                <div class="md-headline" style="margin:20px 0">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</div>
                <div class="md-headline" style="margin:20px 0">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</div>
                <div class="md-headline" style="margin:20px 0">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</div>
                <div class="md-headline" style="margin:20px 0">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</div>
                <div class="md-headline" style="margin:20px 0">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</div>
                <div class="md-headline" style="margin:20px 0">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</div>
              </div>
            </div>
    </div>
  </div>
</template>

<style lang="scss">

  .textGrid {
    height:650px;
    overflow:auto;
    display:none;
  }

  .aboutMainGrid {
    position:absolute;
    top:0;
    height:100vh;
    width:100vw;
    opacity:1;
  }

  .rootAbout {
    width:80vw;
    height:60vh;
    margin:0 auto;
    position:relative;
    top: 225px;
    color:white;
  }

</style>

<script>
import ScrollMagic from "scrollmagic"
import { TimelineMax, TweenMax } from "gsap"

export default {
    name:"AboutDrawer",
    mounted: function() {
      this.$store.commit("Scroll/setElements", [
        { key:"aboutDrawer", value: document.querySelector(".rootAbout") }
      ])
      this.addAboutScene();
    },
    data() {
      return {
          reverseAdded: false
      }
    },
    methods: {
      addAboutScene() {
        let { aboutDrawer } = this.$store.state.Scroll

        let timeline = new TimelineMax();
        let heroTween = TweenMax.fromTo("#imageGridPort", 1,  { opacity: 1 }, { opacity: 0 });
        let aboutTween = TweenMax.fromTo(".rootAbout", 1,  { opacity: 0 }, { opacity: 1 });
        let textTween = TweenMax.fromTo(".textGrid", 1,  { display: "none" }, { display: "block" });

        timeline.add(heroTween).add(aboutTween).add(textTween);

        let aboutScene = new ScrollMagic.Scene({
                                duration: 250,
                                offset: $(window).height() * 2
                              }).setTween(timeline).on("start", (e) => {
                                if(!this.reverseAdded) this.addReverseAboutScene();
                                if(e.scrollDirection == "REVERSE")
                                  this.$store.commit("About/toggleOpen", false)
                              }).on("end", (e) => {
                                if(e.scrollDirection == 'FORWARD')
                                  this.$store.commit("About/toggleOpen", true)
                              })

        this.$store.dispatch("Scroll/addScene", aboutScene)
      },
      addReverseAboutScene()  {
        let { aboutDrawer } = this.$store.state.Scroll

        let timeline = new TimelineMax();
        let heroTween = TweenMax.fromTo("#imageGridAbout", 1,  { opacity: 1 }, { opacity: 0 });
        let aboutTween = TweenMax.fromTo(".rootAbout", 1,  { opacity: 1 }, { opacity: 0 });

        timeline.add(heroTween).add(aboutTween);

        let aboutReverseScene = new ScrollMagic.Scene({
                                      duration: 250,
                                      offset: $(window).height() * 3
                                    }).setTween(timeline).on("start", (e) => {
                                      if(e.scrollDirection == "REVERSE")
                                        this.$store.commit("About/toggleOpen", true)
                                    }).on("end", (e) => {
                                      if(e.scrollDirection == 'FORWARD')
                                        this.$store.commit("About/toggleOpen", false)
                                    })

        this.reverseAdded = true
        this.$store.dispatch("Scroll/addScene", aboutReverseScene)
      }
    }
}
</script>
