export default {
  namespaced:true,
  state: {
    portfolioOpen: false,
    items:[
      {
        id:"0",
        thumbnail:"https://www.phillymag.com/wp-content/uploads/sites/3/2020/03/mexican-quinoa-casserole-main-2.jpg",
        header:"12 Healthy Recipes for 2020",
        category:"Cooking, Living",
        content:`Lorem ipsum dolor sit
          amet consectetur adipisicing elit. Ratione dolor nemo consectetur possimus
          vero libero quo dignissimos qui sint odit.`,
        date:"today"
      },
      {
        id:"1",
        thumbnail:"https://www.lifewire.com/thmb/kc1wqukCIVUR1AHVSdG5EYSA1D8=/768x0/filters:no_upscale():max_bytes(150000):strip_icc()/city_AlexanderSpatari_Getty-5a13972b47c26600378f0216.jpg",
        header:"The Number One Travel Mistake you're making and how to fix it",
        category:"Traveling",
        content:`Lorem ipsum dolor sit
          amet consectetur adipisicing elit.`,
        date:"yesterday"
      },
      {
        id:"2",
        thumbnail:"https://www.privatetour.com/uploads/images/grand-canyon-top-15-places-to-visit-in-the-usa.jpg",
        header:"15 places to visit before the years over",
        category:"Traveling",
        content:`Lorem ipsum dolor sit
          amet consectetur adipisicing elit. Ratione dolor nemo consectetur possimus
          vero libero quo dignissimos qui sint odit, quod deserunt?`,
        date:"yesterday"
      },
      {
        id:"3",
        thumbnail:"https://d50b62f6164e0c4a0279-11570554cb5edae3285603e6ab25c978.ssl.cf5.rackcdn.com/html_body_blocks/images/000/012/086/original/Working_Out_At_Home_en0937fe4aa74cdcc072e8bb6de22ecf02.jpg?1556079435",
        header:"Working out at home",
        category:"Living, Fitness",
        content:`Lorem ipsum dolor sit
          amet consectetur adipisicing elit.`,
        date:"yesterday"
      },
      {
        id:"4",
        thumbnail:"https://www.opendoor.com/w/wp-content/uploads/2018/06/Real-estate-fundamentals-1.jpg",
        header:"Why our real estate market is crashing",
        category:"Real Estate",
        content:`Lorem ipsum dolor sit
          amet consectetur adipisicing elit.`,
        date:"yesterday"
      },
      {
        id:"5",
        thumbnail:"https://media.cntraveler.com/photos/5a82f0054ff8184d0cc2d98a/4:3/w_420,c_limit/Sylvain__2018_DSC_5680.jpg",
        header:"15 best places to eat in New Orleans",
        category:"Food",
        content:`Lorem ipsum dolor sit.`,
        date:"yesterday"
      },
      {
        id:"6",
        thumbnail:"https://resc-files-prod.s3.us-west-1.amazonaws.com/s3fs-public/styles/large/public/2018-12/choosing-the-right-pet-for-you_1.jpg?itok=WtIcHUf-",
        header:"Picking the right animal for you",
        category:"Living",
        content:`Lorem ipsum dolor sit
          amet consectetur adipisicing elit. Ratione dolor nemo consectetur possimus
          vero libero quo dignissimos qui sint odit.`,
        date:"yesterday"
      },
      {
        id:"7",
        thumbnail:"https://img.huffingtonpost.com/asset/59e7bfce1800004206dfb201.jpeg?ops=crop_0_165_5760_3226%2Cscalefit_720_noupscale",
        header:"Household decor",
        category:"Design, Living",
        content:`Lorem ipsum dolor sit
          amet consectetur adipisicing elit. Ratione dolor nemo consectetur possimus
          vero libero quo dignissimos qui sint odit.`,
        date:"yesterday"
      },
      {
        id:"8",
        thumbnail:"https://s3.amazonaws.com/finecooking.s3.tauntonclud.com/app/uploads/2017/04/18204210/051111077-01-pad-thai-recipe-main.jpg",
        header:"Guide to cooking authentic recipes",
        category:"Cooking, Food",
        content:`Lorem ipsum dolor sit
          amet consectetur adipisicing elit?`,
        date:"yesterday"
      },
      {
        id:"9",
        thumbnail:"https://static.parade.com/wp-content/uploads/2019/12/new-years-resolution-ideas.jpg",
        header:"How to achieve that new years resolution",
        category:"Lifestyle",
        content:`Lorem ipsum dolor sit
          amet consectetur adipisicing elit. Ratione dolor nemo.`,
        date:"yesterday"
      },
      {
        id:"10",
        thumbnail:"https://akm-img-a-in.tosshub.com/indiatoday/images/bodyeditor/201912/CS-Economy-Dec16-1_770_1-x433.jpg?0eFSuyj.im_8QVjsix8uyCw3ZkkixKdL",
        header:"The economy and how to fix it",
        category:"Economics",
        content:`Lorem ipsum dolor sit
          amet consectetur adipisicing elit. Ratione dolor nemo consectetur possimus
          vero libero quo dignissimos qui?`,
        date:"today"
      },
      {
        id:"11",
        thumbnail:"https://i.pcmag.com/imagery/lineups/04euMtXNWEe98V4QjChWDyB-1.fit_lim.size_1200x630.v_1576805953.jpg",
        header:"10 best shows on Netflix",
        category:"Entertainment",
        content:`Lorem ipsum dolor sit
          amet consectetur adipisicing elit. Ratione dolor nemo consectetur possimus
          vero libero quo dignissimos.`,
        date:"yesterday"
      },
      {
        id:"12",
        thumbnail:"https://www.publicagenda.org/wp-content/uploads/bb-plugin/cache/Divisiveness-and-Collaboration-in-American-Public-Life_SOCIAL-panorama.jpg",
        header:"The hidden issues in America",
        category:"Politics",
        content:`Lorem ipsum dolor sit
          amet consectetur adipisicing elit. Ratione dolor nemo consectetur possimus
          vero libero quo dignissimos qui sint odit.`,
        date:"yesterday",
      }
  ]
  },
  mutations: {
    addItem(state, data) {
     state.items.push(data)
   },
   addReverseScene(state, payload) {
     state.addReverseScene = payload
   },
   setDrawerOpen(state, payload) {
     state.portfolioOpen = payload
   }
  },
  actions:{
    addItem({commit, dispatch}, data){
      commit('addItem', data)
    }
  },
  getters: {
    getItems: state => state.items
  }
}
