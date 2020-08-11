<template>
  <v-lazy height="110vh">
    <div id="rootContactPage">
      <v-row justify="center" align="center" style="width:90%;margin:0 auto;">
        <v-col cols="8" class="portfolioSeperator"></v-col>
        <v-col cols="2" class="text-h5 text-center">Let's Talk</v-col>
        <v-col cols="2" class="portfolioSeperator"></v-col>
      </v-row>
      <div id="rootContactGrid">
        <div id="innerContactGrid">
          <form id="contact_form" @submit="submitForm" method="POST" action="/getAll">
            <p class="text-h5" style="margin:25px auto 0">
              My Name is <input class="field" v-model="contact_name" id="contact_name" name="contact_name" placeholder="Full Name" required />
              you can reach me at <input class="field" v-model="contact_email" id="contact_email" name="contact_email" type="email" placeholder="Email" required/>
              or <input class="field" v-model="contact_phone" id="contact_phone" name="contact_phone" placeholder="Phone Number"/>
              and I want to talk about <Textarea class="field textAreaField" v-model="contact_message" id="contact_message" name="contact_message" placeholder="Message"/>
              P.S. <Textarea class="field textAreaField" v-model="contact_other" id="contact_other" name="contact_other" placeholder="Anything else?"/>
            </p>
            <input class="submitButton" type="submit" value="Send" />
          </form>
        </div>
      </div>
    </div>
  </v-lazy>
</template>

<style>

  #rootContactPage {
    width:100vw;
    max-width:1100px;
    padding:30px 0;
    margin:0 auto;
  }

  .portfolioSeperator {
    height:2px;
    background:grey;
    opacity:.5;
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

  .md-field:after {
    display:none;
  }

</style>

<script>
  export default {
    name:"ContactPage",
    data() {
      return {
        contact_name: null,
        contact_email:null,
        contact_phone:null,
        contact_message:null,
        contact_other:null
      }
    },
    methods: {
      submitForm: function() {
        console.log('here', this)
        // if(e.data == null) this[stateProp] = ""
        // else this[stateProp] += e.data
        // console.log(this[stateProp], e.data)
      }
    }
  }
</script>
