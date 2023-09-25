

<template>
  <form  @submit.prevent="createStore">

    <label for="exampleFormControlTextarea1">Mağaza Adı</label>
    <input class="form-control" v-model="store.store_name" required>

    <label for="exampleFormControlTextarea1">Mağaza Türü</label>
    <input class="form-control" v-model="store.store_type" required>

    <label for="exampleFormControlTextarea1">Mağaza Linki</label>
    <input class="form-control" v-model="store.store_link" required>

    <label>Şehir:</label>
    <select v-model="store.city" required @change="getDistricts">
      <option  class="option"  v-for="item in items" :key="item">
        {{item}}
      </option>
    </select>

    <label>İlçe:</label>
    <select v-model="store.district" required>
      <option class="option" v-for="item in differentItem" :key="item" :value="item">
        {{item}}
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
        store_name:'',
        store_link:''
      },
      items: [],
      differentItem: [
      ]
    };
  },
  created() {
    this.getCities();
  },
  methods:{
    async createStore(){
      try{
        axios.post('http://10.20.1.126:8081/api/store/create-stores',this.store).then((response)=>{
          this.store = response.data;
        })
      }
      catch(error){
        console.error('hata!!',error)
      }
    },

    async getCities(){
      try{
        axios.get('http://10.20.1.126:8081/api/city/get-all-cities').then((response)=>{
          this.items = response.data;
          console.log(this.items);
        })
      }
      catch (error){
        console.error('hata!!',error)
      }
    },

    async getDistricts(){
      try{
        axios.get('http://10.20.1.126:8081/api/district/get-all-districts?city='+this.store.city)
        .then((response)=>{
          this.differentItem = response.data;
          console.log(this.differentItem);
        })
      }
      catch (error){
        console.error('hata!!',error)
      }
    }
  }
};
</script>

<style scoped>

</style>