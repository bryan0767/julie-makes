<template lang="html">
  <v-app v-if="!loading">

    <v-snackbar v-model="errorSnackbar">
      {{ errorText }} <v-btn color="pink lighten-3" text @click="errorSnackbar = false">Close</v-btn>
    </v-snackbar>
    <v-row v-if="!loggedIn" class="loginRow" justify="center">
      <div class="text-h4">Admin Login</div>
      <v-col cols="12">
        <label>Username</label>
        <input type="input" v-model="username" class="inputStyles" />
      </v-col>
      <v-col cols='12'>
        <label>Password</label>
        <input type="input" v-model="password" class="inputStyles" />
      </v-col>
      <v-btn @click="loginUser()">Login</v-btn>
    </v-row>
    <v-row v-else>

      <!-- Admin Panel Left -->

      <v-col sm="3" style="position:relative" class="hidden-sm-and-down">
        <v-navigation-drawer width="100%" class="mainNav" permanent hideOverlay>
          <div class="text-h4 navHeader d-flex justify-flex-start align-center" style="padding:0 15px;max-height:100px">Admin</div>
          <v-list>
            <v-list-item @click="clear(page)"
                         v-for="page in Object.keys($store.state.Admin.data)"
                         two-line style="color:white !important"
                         class="subtitle-1 text-capitalize">{{ page }}</v-list-item>
          </v-list>
        </v-navigation-drawer>
      </v-col>

      <div class="hidden-md-and-up" style="position:fixed;top:25px;z-index:999;right:25px">
        <v-icon @click="drawer = !drawer">mdi-menu</v-icon>
        <v-navigation-drawer width="100%" class="mainNav" v-model="drawer" fixed hideOverlay>
          <div class="navHeader d-flex justify-flex-start align-center" style="padding:0 15px;max-height:100px">
            <div class="text-h4">Admin</div>
            <v-icon style="position:absolute;right:25px;color:white" @click="drawer=false">mdi-close</v-icon>
          </div>
          <v-list>
            <v-list-item @click="clear(page)"
                         v-for="page in Object.keys($store.state.Admin.data)"
                         two-line style="color:white !important"
                         class="subtitle-1 text-capitalize">{{ page }}</v-list-item>
          </v-list>
        </v-navigation-drawer>
      </div>


      <!-- End Admin Panel Left -->

      <!-- Main Admin Panel View -->

      <v-col xs="12" sm="9" style="padding:20px;height:100vh;overflow:auto;margin:0 auto" v-if="!articleView">
        <div class="text-h4 font-weight-light text-capitalize">{{ currentPage['page'] }}</div>

        <div v-for="option in Object.keys(currentPage)" v-if="currentPage[option] != null">

          <v-row v-if="Array.isArray(currentPage[option]) && currentPage[option].length">

            <v-col cols="12" class="text-subtitle-1 text-capitalize d-flex" style="margin: 15px 0">
              {{ option }}
              <v-tooltip top>
                <template  v-slot:activator="{ on, attrs }">
                  <v-icon v-on="on" dark v-bind="attrs" v-if="option == 'icons'" style="font-size:12px;margin:0 5px;color:black">mdi-help</v-icon>
                </template>
                Julie, all icon names need to start with 'mdi-' </br> You can find all available icons at {{ iconLink }}
              </v-tooltip>
            </v-col>

            <v-row v-for="(arrayField, ind) in currentPage[option]" >

              <v-col v-if="option == 'icons'" xs='12' style="margin:0 5px 10px 0;maxWidth:250px">
                <label :for="`${ind}-label-link`">Link</label>
                <input :id="`${ind}-label-link`" type="input" v-model="currentPage[option][ind]['link']" class="inputStyles" style="margin:0 0 10px 0" />
                <label :for="`${ind}-label-icon`">Icon</label>
                <input :id="`${ind}-label-icon`" type="input" v-model="currentPage[option][ind]['src']" class="inputStyles" style="margin:0 0 10px 0" />
                <v-icon>{{ currentPage[option][ind]['src'] }}</v-icon>

              </v-col>

              <v-col v-if="option == 'images'" style="margin:0 5px 10px 0;" class="adminImagesGrid">
                <div :style="{background:`url('${currentPage[option][ind]['src']}') center/cover no-repeat`, height:'250px', width:'100%'}"></div>
                <input type="input" v-model="currentPage[option][ind]['src']" class="inputStyles" style="margin-top:10px" />
              </v-col>

            </v-row>

            <div v-if="option == 'articles'" style="margin:0 0 20px 0;" >
              <v-btn @click="transitionArticle()">Edit Articles</v-btn>
            </div>

          </v-row>

          <div v-else-if="!Array.isArray(currentPage[option]) && option != 'page'">
            <div class="text-subtitle-1 text-capitalize" style="margin:15px 0"> {{ option }} </div>
            <textarea v-if="currentPage[option].length > 40" v-model="currentPage[option]" class="adminTextArea" />
            <input v-else v-model="currentPage[option]" type="input" class="inputStyles" style="width:fit-content"/>
          </div>

        </div>

      </v-col>

      <!-- End Main Admin Panel View -->

      <!-- article section -->

      <v-col v-else style="padding:20px;overflow:auto;height:100vh;">

        <v-btn @click="resetViews()" style="margin:0 0 20px">Back To Portfolio</v-btn>
        <v-btn @click="resetToArticles()" style="margin:0 0 20px" v-if="showArticle || newArticleView">Back To Articles</v-btn>
        <v-btn @click="goToAddArticle()" style="margin:0 0 20px" v-if="articleView && !showArticle && !newArticleView">New Article</v-btn>

        <!--  -->
        <v-dialog v-model="dialog" width="500" v-if="showArticle">
          <template v-slot:activator="{ on, attrs }">
            <v-btn color="red lighten-2" dark v-bind="attrs" v-on="on" style="margin:0 0 20px" >
              Delete Article
            </v-btn>
          </template>
          <v-card>
            <v-card-text style="padding:20px">
              Are you sure you want to delete this Julie ?
            </v-card-text>
            <v-divider></v-divider>
            <v-card-actions>
              <v-spacer></v-spacer>
              <v-btn color="primary" text @click="dialog = false">
                Never Mind
              </v-btn>
              <v-btn color="primary" text @click="deleteArticle()">
                Delete
              </v-btn>
            </v-card-actions>
          </v-card>
        </v-dialog>
        <!--  -->

        <v-row v-if="!showArticle && !newArticleView">
          <v-col v-for="(article, ind) in currentPage.articles"
                 @click="editArticle( $event, article, ind )" class="portfolioItem" :key="ind" style="margin-right:10px">
              <div class="portfolioItemImage" :style="{ background:`url('${article.thumbnail}') center/cover no-repeat`, position:'relative' }"></div>
              <div class="portfolioPageItemCategory text-caption">{{ article.category }}</div>
              <div class="portfolioPageItemHeader text-subtitle-2">{{ article.header }}</div>
              <div class="portfolioPageItemDescription">{{ article.content }}</div>
          </v-col>
        </v-row>

        <v-row v-else-if="showArticle">
          <v-col v-for="field in Object.keys(currentArticle)" cols="12">
            <div v-if="!['id', 'page'].includes(field)">
              <div class="text-subtitle-1 text-capitalize" style="margin:15px 0"> {{ field }} </div>
              <textarea type="input" v-model="currentArticle[field]" class="inputStyles" />
            </div>
          </v-col>
        </v-row>

        <v-row v-else-if="newArticleView">
          <v-col v-for="field in Object.keys(newArticle)" cols="12">
            <div v-if="!['page'].includes(field)">
              <div class="text-subtitle-1 text-capitalize" style="margin:15px 0"> {{ field }} </div>
              <textarea type="input" v-model="newArticle[field]" class="inputStyles" />
            </div>
          </v-col>
        </v-row>

      </v-col>

      <!-- end article section -->

      <!-- buttons -->
      <v-row style="position:fixed;bottom:0;background:white;width:100%;position:relative" justify="center">
      <!-- Main Save Buttons -->
        <div v-if="changesMade && !showArticle" class="d-flex justify-flex-start adminButtonGrid justify-center">
          <v-btn @click="savePage()">Save</v-btn>
          <v-btn style="margin:0 20px" @click="clear(currentPage['page'])">Clear</v-btn>
        </div>
        <!-- Main Save Buttons -->

        <!-- Article Save Buttons ( editing ) -->
        <div v-if="articleChanged && showArticle" class="d-flex justify-flex-start adminButtonGrid justify-center">
          <v-btn @click="saveArticle()">Save</v-btn>
          <v-btn style="margin:0 20px" @click="clearArticle()">Clear Article</v-btn>
        </div>
        <!-- Article Save Buttons ( editing ) -->

        <!-- Article Save Buttons ( editing ) -->
        <div v-if="newArticleView" class="d-flex justify-flex-start adminButtonGrid justify-center">
          <v-btn @click="saveNewArticle()">Save</v-btn>
          <v-btn style="margin:0 20px" @click="clearNewArticle()">Clear Fields</v-btn>
        </div>
        <!-- Article Save Buttons ( editing ) -->
      <!-- end buttons -->
      </v-row>
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
                                      this.$watch('currentPage', this.handlePageChange, { deep:true })
                                    })
                      })
    },
    data() {
      return {
        loading:true,
        currentPage:{},
        errorSnackbar: false,
        errorText: "",
        changesMade:false,
        iconLink: "https://materialdesignicons.com/",
        articleView:false,
        showArticle: false,
        currentArticle: {},
        articleChanged: false,
        newArticleView: false,
        newArticle: {
          thumbnail:'',
          header:'',
          category:'',
          description:'',
          heroimage:'',
          content:'',
          date:'',
          link:'',
          page:'portfolio'
        },
        dialog: false,
        drawer: false,
        loggedIn: false,
        username:"",
        password: ""
      }
    },
    methods: {
      loginUser() {

        let body = {
          username:this.username,
          password:this.password
        }

        fetch("/login", {
          method: "POST",
          headers: {
            'Content-type':'application/json'
          },
          body: JSON.stringify(body)
        }).then(blob => blob.json())
          .then(res => {
              if(res == true) {
                this.loggedIn = true
              } else {
                this.errorText = "Invalid Username or Password"
                this.errorSnackbar = true
              }
          })
      },
      clear(page) {
        fetch(`/getPage?page=${page}`).then(blob => blob.json())
                                      .then(x => {
                                        this.currentPage = x
                                        setTimeout(() => this.changesMade = false, 0 )
                                        this.articleView = false
                                        this.drawer = false
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
          setTimeout(() => this.changesMade = false, 0 )
        })
      },
      handlePageChange() {
        this.changesMade = true
        console.log('changes being made')
      },
      editArticle(e, article, ind) {
        this.showArticle = true
        this.currentArticle = article
        this.dialog = false
        this.$watch('currentArticle', this.handleArticleChange, { deep: true })
      },
      handleArticleChange() {
        this.articleChanged = true
      },
      saveArticle() {

        fetch(`/editArticle/${this.currentArticle['id']}`, {
          method:"PUT",
          headers: {
            "Content-type": "application/json"
          },
          body: JSON.stringify(this.currentArticle)
        }).then(res => {
          this.errorText = "Article Edited!!"
          this.errorSnackbar = true
          this.articleChanged = false
        })

      },
      saveNewArticle() {
        fetch("/postArticle", {
          method:"POST",
          headers: {
            'Content-type': 'application/json'
          },
          body: JSON.stringify(this.newArticle)
        }).then(x => {
          this.errorText = "New Article Saved!!"
          this.errorSnackbar = true
          this.newArticleView = false
          setTimeout(() => this.clearNewArticle(), 10 )
          fetch(`/getPage?page=portfolio`).then(blob => blob.json())
                                        .then(x => {
                                          this.currentPage = x
                                          setTimeout(() => this.changesMade = false, 0 )
                                        })
        })
      },
      clearArticle() {
        fetch(`/getArticle/${this.currentArticle['id']}`).then(blob => blob.json())
                                                         .then(x => {
                                                           this.currentArticle = x
                                                           setTimeout(() => this.articleChanged = false, 0 )
                                                         })
      },
      resetViews() {
        this.articleView = false;
        this.showArticle = false;
        this.articleChanged = false;
        this.changesMade = false;
        this.dialog = false
        this.clear('portfolio')
      },
      transitionArticle() {
        this.articleView = true;
        this.changesMade = false;
        this.showArticle = false;
        this.articleChanged = false;
        this.dialog = false
      },
      resetToArticles(){
        this.showArticle = false;
        this.aticleChanged = false;
        this.articleView = true;
        this.changesMade = false;
        this.newArticleView = false;
        this.dialog = false
      },
      goToAddArticle() {
        this.newArticleView = true;
        this.articleView = true;
        this.showArticle = false;
        this.dialog = false
      },
      clearNewArticle() {
        this.newArticle = {
          thumbnail:'',
          header:'',
          category:'',
          description:'',
          heroimage:'',
          content:'',
          date:'',
          link:'',
          page:'portfolio'
        }
      },
      deleteArticle(){
        let id = this.currentArticle.id

        fetch(`/deleteArticle/${id}`, {
          method: "DELETE",
          headers: {
            'Content-type': 'application/json; charset=UTF-8' // Indicates the content
          },
        }).then(res => {
          this.errorText = "Article Deleted!!"
          this.errorSnackbar = true
          this.showArticle = false
          fetch(`/getPage?page=portfolio`).then(blob => blob.json())
                                          .then(x => {
                                            this.currentPage = x
                                            setTimeout(() => this.changesMade = false, 0 )
                                            console.log(this.currentPage, 'the page data?')
                                          })
        })
      }
    }
  }
</script>

<style>

  .loginRow {
    position:relative;
    top:50%;
    transform:translateY(-50%);
    max-height:400px;
    max-width:400px;
    padding:40px;
    margin:0 auto;
  }

  .adminImagesGrid {
    max-width: 250px
  }

  .adminButtonGrid {
     position:absolute;
     bottom:0;
     width:100%;
     left:0;
     padding:15px;
     background:white;
  }

  .adminTextArea {
    height:500px;
    max-height:1000px;
    padding:10px;
    max-height:100px;
    width:100%;
    border:.5px solid #cac5c5;
    color:grey;
    outline:none;
  }

  .inputStyles {
    border-bottom:.5px solid #cac5c5;
    color:grey;
    padding:10px 0;
    max-height:100px;
    width:100%;
    outline:none;
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

  .portfolioItem {
    width:min-content;
    transition: all 0.8s ease-in-out;
    flex:initial;
    padding: 20px;
    border: .2px solid #e8e8e8;
    background:white;
    cursor: pointer;
  }

  .portfolioItemImage {
    height:160px;
    width:240px;
    border-radius:10px;
  }

  .portfolioPageItemCategory {
    margin:15px 0 5px;
    font-size:12px;
  }

  .portfolioPageItemHeader {
    font-size:18px;
    line-height:20px;
  }

  .portfolioPageItemDescription {
    margin:5px 0;
    font-size:12px;
  }

  @media (max-width: 599px) {
    .adminImagesGrid {
      max-width:initial;
    }
  }

</style>
