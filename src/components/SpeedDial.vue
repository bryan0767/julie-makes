<template>
  <v-speed-dial
       v-model="fab"
       bottom
       left
       direction="top"
       :fixed="true"
       mode="scale" >
       <template v-slot:activator>
         <v-fab-transition>
           <v-btn v-show="$store.state.Home.showFab" v-model="fab" color="white" dark fab style="color:#eab4ad">
             <v-icon v-if="fab">mdi-close</v-icon>
             <v-icon v-else>mdi-menu</v-icon>
           </v-btn>
        </v-fab-transition>
       </template>
       <v-btn fab dark small color="white" @click="movePage('#rootGrid')">
         <v-icon color="#eab4ad">mdi-home</v-icon>
       </v-btn>
       <v-btn fab dark small color="white" @click="movePage('#rootPortfolioGrid')">
         <v-icon color="#eab4ad">mdi-pen</v-icon>
       </v-btn>
       <v-btn fab dark small color="white" @click="movePage('#rootAboutPage')">
         <v-icon color="#eab4ad">mdi-emoticon-happy-outline</v-icon>
       </v-btn>
       <v-btn fab dark small color="white" @click="movePage('#rootContactPage')">
        <v-icon color="#eab4ad">mdi-mail</v-icon>
      </v-btn>
    </v-speed-dial>
</template>

<script>

export default {
  name:"SpeedDial",
  data() {
    return {
      fab:false
    }
  },
  methods: {
    movePage(value) {
        $('html, body').animate({
            scrollTop: $(value).offset().top
        }, 2000);
    }
  }
}
</script>

<style>

</style>
