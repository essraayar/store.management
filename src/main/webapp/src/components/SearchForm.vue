<template>
  <form @submit.prevent="search">
    <h3>Mağaza Arama</h3>
    <label>Şehir:</label>
    <select v-model="cityInput" @change="getDistricts" >
      <option  class="option"  v-for="item in items" :key="item">
        {{item}}
      </option>
    </select>

    <label>İlçe:</label>
    <select v-model="districtInput">
      <option class="option" v-for="item in differentItem" :key="item" :value="item">
        {{item}}
      </option>
    </select>

    <div class="submit">
      <br>
      <br>
      <button>Arama Yap</button>
    </div>
  </form>

  <div>
    <table class="table table-striped"  v-if= visible>
      <thead>
      <tr>
        <th scope="col">Mağaza Adı</th>
        <th scope="col">Mağaza Türü</th>
        <th scope="col">Şehir</th>
        <th scope="col">İlçe</th>
        <th scope="col">Mağaza Linki</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for ="s in store" :key="s">
        <td>{{s.store_name}}</td>
        <td>{{s.store_type}}</td>
        <td>{{s.city}}</td>
        <td>{{s.district}}</td>
        <td><a :href="s.store_link">{{s.store_link}}</a></td>
      </tr>
      </tbody>
    </table>
  </div>
</template>


<script>
import axios from "axios";
//import CreateStoreForm from "@/components/CreateStoreForm.vue";

export default {
  name: "SearchForm",
  //components: {CreateStoreForm},
  data(){
    return{
      visible:true,
      items: [],
      differentItem: [],
      cityInput:null,
      districtInput:null,
      store: [
        {
        store_type:'',
        city:null,
        district:null,
        store_name:'',
        store_link:''}
    ]
    }
  },

  created() {
    this.getCities();
    },
  methods:{

    search(){
      this.visible=true;
      this.getStores();
    },
    async getStores(){
      try{
        console.log("Seçtiğiniz il :"+ this.cityInput);
        console.log("Seçtiğiniz ilçe :"+ this.districtInput);
        var thizz=this;
        axios.get('http://10.20.1.126:8081/api/store/get-stores?city='+thizz.cityInput+'&district='+thizz.districtInput).then((response)=>{
          this.store = response.data;
          console.log(this.store);
        })
      }
      catch (error){
        console.error('hata!!',error)
      }
    },
    async getCities(){
      try{
        axios.get('http://10.20.1.126:8081/api/city/get-all-cities').then((response)=>{
          this.items = response.data;
          console.log("BURADAAA")
          console.log(this.items);
        })
      }
      catch (error){
        console.error('hata!!',error)
        console.log("BURADAAHATAAA")
      }
    },

    async getDistricts(){
      try{
        axios.get('http://10.20.1.126:8081/api/district/get-all-districts?city='+this.cityInput)
            .then((response)=>{

              this.differentItem = response.data;
              console.log(this.differentItem);
              this.districtInput=null;

            })
      }
      catch (error){
        console.error('hata!!',error)
      }
    }
  }
}

</script>

<style scoped>

</style>