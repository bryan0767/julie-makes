<template>
  <div class="rootContact">
    <div class="contact">
      <div class="contactGrid md-layout md-alignment-top-center">
        <div class="md-layout-item inputGrid md-size-50">
          <input class="contactInput" placeholder="name" type="input"  />
          <input class="contactInput" placeholder="email" type="email" />
          <input class="contactInput" placeholder="message" type="message" />
          <input class="contactInput" placeholder="submit" type="submit" />
        </div>
      </div>
    </div>
  </div>
</template>

<style lang="scss">

  .inputGrid {
    // border:2px solid green;
    // background: blue;
  }

  .rootContact {
    width:100vw;
    height:100vh;
    position:absolute;
    top:0;
  }

  .contact {
    width:100%;
    height:100vh;
    display:flex;
  }

  .contactGrid {
    flex-direction: column;
    width:100%;
  }

  .contactInput {
    display:block;
    padding: 20px;
    border-radius:10px;
    background: none;
    color:white !important;
    border:none;
    margin: 0 auto;
    text-align: center;
    border:none;
    box-shadow:none;
  }

</style>

<script>
import ScrollMagic from "scrollmagic"
import { TimelineMax, TweenMax } from "gsap"

export default {
    name:"ContactDrawer",
    mounted: function() {
      this.$store.commit("Scroll/setElements", [
        { key:"contactDrawer", value: document.querySelector(".contactDrawer") }
      ])
      this.addContactScene();
    },
    data() {
      return {
          reverseAdded: false
      }
    },
    methods: {
      addContactScene() {
        let { contactDrawer } = this.$store.state.Scroll

        let timeline = new TimelineMax();
        let heroTween = TweenMax.fromTo("#imageGridContact", 1,  { opacity: 0 }, { opacity: 1 });
        let aboutTween = TweenMax.fromTo(".rootContact", 1,  { opacity: 0, display:"none" }, { opacity: 1, display:"block" });
        let textTween = TweenMax.fromTo(".inputGrid", 1,  { display: "none" }, { display: "block" });

        timeline.add(heroTween).add(aboutTween).add(textTween)

        let contactScene = new ScrollMagic.Scene({
                                duration: 250,
                                offset: $(window).height() * 3
                              }).setTween(timeline).on("start", (e) => {
                                // if(!this.reverseAdded) this.addReverseContactScene();
                                if(e.scrollDirection == "REVERSE")
                                  this.$store.commit("Contact/toggleOpen", false)
                              }).on("end", (e) => {
                                if(e.scrollDirection == 'FORWARD')
                                  this.$store.commit("Contact/toggleOpen", true)
                              })

        this.$store.dispatch("Scroll/addScene", contactScene)
      },
      addReverseContactScene()  {
        let { portfolioDrawer } = this.$store.state.Scroll
        let aboutDrawer = document.querySelector(".rootAboutDrawer")
        let aboutReverseScene = new ScrollMagic.Scene({
          duration: 250,
          offset: $(window).height() * 4
        }).setTween(".rootAboutDrawer", 1, {
            transform: "translate3d(0, 100%, 0)",
            opacity:0
        }).on("start", (e) => {
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
