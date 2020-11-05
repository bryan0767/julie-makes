<template lang="html">
  <v-app v-if="!loading">
    <v-snackbar v-model="errorSnackbar">
      {{ errorText }} <v-btn color="pink lighten-3" text @click="errorSnackbar = false">Close</v-btn>
    </v-snackbar>
    <v-row>
      <v-col cols="3" style="position:relative">
        <v-navigation-drawer width="100%" class="mainNav" permanent>
          <div class="text-h4 navHeader d-flex justify-flex-start align-center" style="padding:0 15px">Admin</div>
          <v-list>
            <v-list-item @click="clear(page)"
                         v-for="page in Object.keys($store.state.Admin.data)"
                         two-line style="color:white !important"
                         class="subtitle-1 text-capitalize">{{ page }}</v-list-item>
          </v-list>
        </v-navigation-drawer>

        <div v-if="changesMade == true" class="d-flex justify-flex-start adminButtonGrid">
          <v-btn @click="savePage()">Save</v-btn>
          <v-btn style="margin:0 20px" @click="clear(currentPage['page'])">Clear</v-btn>
        </div>

      </v-col>
      <v-col cols="9" style="padding:20px;height:100vh;overflow:auto;">
        <div class="text-h4 font-weight-light text-capitalize">{{ currentPage['page'] }}</div>

        <div v-for="option in Object.keys(currentPage)" v-if="currentPage[option] != null">

          <v-row v-if="Array.isArray(currentPage[option]) && currentPage[option].length">

            <v-col cols="12" class="text-subtitle-1 text-capitalize" style="margin: 15px 0">
              {{ option }}
              <v-tooltip top>
                <template  v-slot:activator="{ on, attrs }">
                  <v-icon v-on="on" dark v-bind="attrs" v-if="option == 'icons'" style="font-size:15px;margin:0 5px;color:black">mdi-help</v-icon>
                </template>
                Julie, all icon names need to start with 'mdi-' </br> You can find all available icons at {{ iconLink }}
              </v-tooltip>
            </v-col>

            <v-col v-for="(arrayField, ind) in currentPage[option]" :cols="option != 'articles' ? 12 / currentPage[option].length : 12">

              <div v-if="option == 'icons'" style="margin-right:5px">
                <input type="input" v-model="currentPage[option][ind]['src']" class="inputStyles" style="margin:0 0 15px 0" />
                <v-icon>{{ currentPage[option][ind]['src'] }}</v-icon>
              </div>

              <div v-if="option == 'images'" style="margin-right:5px">
                <input type="input" v-model="currentPage[option][ind]['src']" class="inputStyles" style="margin:0 0 15px 0" />
                <div :style="{background:`url('${currentPage[option][ind]['src']}') center/cover no-repeat`, height:'250px', width:'100%'}"></div>
              </div>

              <div v-if="option == 'articles'" style="margin:0 0 20px 0;" >
                here
              </div>

            </v-col>
          </v-row>

          <div v-else-if="!Array.isArray(currentPage[option]) && option != 'page'">
            <div class="text-subtitle-1 text-capitalize" style="margin:15px 0"> {{ option }} </div>
            <textarea v-if="currentPage[option].length > 40" v-model="currentPage[option]" class="inputStyles adminTextArea" />
            <input v-else v-model="currentPage[option]" type="input" class="inputStyles" style="width:fit-content"/>
          </div>

        </div>

      </v-col>
    </v-row>
  </v-app>
</template>

<script>
  export default {
    name:"Admin",
    created: function() {
      fetch("/getAll").then(x => x.json())
                      .then(y => {
                        this.$store.dispatch("Admin/setData", y)
                                    .then(res => {
                                      this.loading = false
                                      this.currentPage = this.$store.state.Admin.data.home
                                      setTimeout(() => this.changesMade = false, 0 )
                                    })
                      })
      this.$watch('currentPage', this.handlePageChange, { deep:true })
    },
    data() {
      return {
        loading:true,
        currentPage:{},
        errorSnackbar: false,
        errorText: "",
        changesMade:false,
        iconLink: "https://materialdesignicons.com/"
      }
    },
    methods: {
      clear(page) {
        fetch(`/getPage?page=${page}`).then(blob => blob.json())
                                      .then(x => {
                                        this.currentPage = x
                                        setTimeout(() => this.changesMade = false, 0 )
                                      })

      },
      savePage() {
        fetch(`/editPage/${this.currentPage['page']}`, {
          method:"PUT",
          headers: {
            "Content-type": "application/json"
          },
          body: JSON.stringify(this.currentPage)
        }).then(x => {
          this.errorText = "Changes Made!!"
          this.errorSnackbar = true
        })
      },
      handlePageChange() {
        this.changesMade = true
        console.log('changes being made')
      }
    }
  }
</script>

<style>

  .adminButtonGrid {
     position:absolute;
     bottom:0;
     width:100%;
     left:0;
     padding:15px;
  }

  .adminTextArea {
    height:500px;
    max-height:1000px
  }

  .inputStyles {
    border:1px solid grey;
    color:grey;
    padding:10px;
    max-height:100px;
    width:100%;
  }

  .mainNav {
    background:#161f2e !important;
    width:auto;
  }

  .navHeader {
    background:pink;
    height:10%;
    color:white;
  }

  .navMenuOption {
    color:white;
  }
</style>
