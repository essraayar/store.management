

<template>
  <form  @submit.prevent="createStore">

    <label for="exampleFormControlTextarea1">Mağaza Adı</label>
    <input class="form-control" v-model="store.store_name">

    <label for="exampleFormControlTextarea1">Mağaza Türü</label>
    <input class="form-control" v-model="store.store_type">

    <label>Şehir:</label>
    <select v-model="store.city">
      <option  class="option"  v-for="item in items" :key="item">
        {{item}}
      </option>
    </select>

    <label>İlçe:</label>
    <select v-model="store.district">
      <option class="option" v-for="item in differentItem" :key="item.name" :value="item.name">
        {{item.name}}
      </option>
    </select>


    <div class="submit">
      <br>
      <br>
      <button>Mağaza Oluştur</button>
    </div>
  </form>
</template>

<script>
import axios from "axios";
export default {
  name: "CreateStoreForm",
  data(){
    return{
      store: {

        store_type:'',
        city:'',
        district:'',
        store_name:''
      },
      items: [
        'İstanbul', 'Ankara','İzmir'
      ],
      differentItem: [
        {name:'Sarıyer', city:'İstanbul', number:1},
        {name:'Beşiktaş', city:'İstanbul', number:2},
        {name:'Üsküdar', city:'İstanbul', number:3},
      ]
    };
  },
  methods:{
    async createStore(){
      try{
        await axios.post('http://10.20.1.126:8081/api/store/create-stores',this.store).then((response)=>{
          this.store = response.data;
        })
      }
      catch(error){
        console.error('hata!!',error)
      }
    }
  }
};
</script>

<style scoped>

</style>