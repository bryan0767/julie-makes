<template>
  <v-row>
    <v-snackbar v-model="errorSnackbar">
      {{ errorText }} <v-btn color="green" text @click="errorSnackbar = false">Close</v-btn>
    </v-snackbar>
    <div id="rootContactPage">
      <v-row justify="center" align="center" style="width:90%;margin:0 auto;">
        <v-col xs="2" sm="8" class="portfolioContactSeperator"></v-col>
        <v-col xs="8" sm="2" class="text-h5 text-center mainContactText">Let's Talk</v-col>
        <v-col xs="2" sm="2" class="portfolioContactSeperator"></v-col>
      </v-row>
      <div id="rootContactGrid">
        <div id="innerContactGrid">
          <form id="contact_form" @submit="submitForm" method="POST" action="/sendMessage">
            <p class="text-h5" style="margin:25px auto 0">
              My Name is <input class="field" v-model="contact_name" id="contact_name" name="contact_name" placeholder="Full Name" required />
              you can reach me at <input class="field" v-model="contact_email" @blur="validateInput($event, 'email')" id="contact_email" name="contact_email" type="email" placeholder="Email" required/>
              or <input class="field" v-model="contact_phone" @blur="validateInput($event, 'phone')" id="contact_phone" name="contact_phone" placeholder="Phone Number"/>
              and I want to talk about <Textarea class="field textAreaField" v-model="contact_message" id="contact_message" name="contact_message" placeholder="Message" required/>
              P.S. <Textarea class="field textAreaField" v-model="contact_other" id="contact_other" name="contact_other" placeholder="Anything else?"/>
            </p>
            <input class="submitButton" type="submit" value="Send" />
          </form>
        </div>
      </div>
    </div>
  </v-row>
</template>

<style>

  #rootContactPage {
    width:100vw;
    max-width:1100px;
    padding:30px 0;
    margin:0 auto;
  }

  .portfolioContactSeperator {
    height:2px;
    background:grey;
    opacity:.5;
    max-height:2px;
    padding:0;
  }

  #innerContactGrid {
    width:650px;
    margin:0 auto;
  }

  .field {
    width:fit-content;
    position: relative;
    top: -.35em;
    border: none;
    background: rgba(140, 140, 140, 0.2);
    outline: none;
    margin: 20px 0;
    font-size: 1.125rem;
    line-height: 2em;
    padding: .7em .75em .5em;
    max-width: 100%;
    transition: background .3s ease;
  }

  .textAreaField {
    min-width: 100%;
    max-width: 100%;
    min-height:120px;
    max-height: 200px;
  }

  .submitButton {
    background: #6b7b6b;
    color:white;
    outline: none;
    font-size: 1.125rem;
    line-height: 2em;
    padding: 5px 10px;
    max-width: 100%;
    transition: background .3s ease;
    border-radius:5px;
    float:right;
    cursor:pointer;
  }

  @media (max-width: 599px) {
    #innerContactGrid {
      max-width: 85%;
      margin:0 auto;
    }

    .portfolioContactSeperator {
      display:none;
    }
  }

</style>

<script>

  import ScrollMagic from "scrollmagic"
  import { TweenMax, TimelineMax } from "gsap"

  export default {
    name:"ContactPage",
    mounted: function() {
      this.addMainScene()
    },
    data() {
      return {
        contact_name: null,
        contact_email:null,
        contact_phone:null,
        contact_message:null,
        contact_other:null,
        errorSnackbar: false,
        errorText: ""
      }
    },
    methods: {
      addMainScene() {
        let timeline = new TimelineMax()
        let sepTween = TweenMax.staggerFrom( ".portfolioContactSeperator", 1, { flex:'0 0 1%' } )
        let mainTextTween = TweenMax.from(".mainContactText", 1, { opacity: 0 })
        let contactFormTween = TweenMax.fromTo("#contact_form", 1, { opacity: 0, transform:"translateY(100px)" }, { opacity: 1, transform:"translateY(0px)" })

        timeline.add(sepTween, 0).add(mainTextTween, 0).add(contactFormTween)

        let mainContactScene = new ScrollMagic.Scene({
          triggerElement: $("#rootContactPage")[0],
          offset: -50,
          duration: 350
        }).setTween(timeline)

        this.$store.dispatch("Scroll/addScene", mainContactScene)
      },
      validateInput(e, type) {

        const emailRegExp = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
        const phoneRegExp = /^\s*(?:\+?(\d{1,3}))?[-. (]*(\d{3})[-. )]*(\d{3})[-. ]*(\d{4})(?: *x(\d+))?\s*$/

        if( type == 'email' && !emailRegExp.test( this.contact_email )  ) {
            this.errorText = "Please Enter a Valid Email"
            this.errorSnackbar = true
            this.contact_email = ""
        }

        if( type == 'phone' && !phoneRegExp.test( this.contact_phone ) ) {
            this.errorText = "Please Enter a Valid Phone Number"
            this.errorSnackbar = true
            this.contact_phone = ""
        }

      },
      submitForm: function() {
        console.log('here', this)
      }
    }
  }
</script>
