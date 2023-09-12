<template>
  <form @submit.prevent="search">
    <h3>Mağaza Arama</h3>

    <label>Şehir:</label>
    <select v-model="selectedItem">
      <option v-for="item in items" :key="item">
        {{item}}
      </option>
    </select>

    <label>İlçe:</label>
    <select v-model="secondSelectedItem">
      <option v-for="item in differentItem" :key="item.name" :value="item.name">
        {{item.name}}
      </option>
    </select>

    <div class="submit">
      <button>Arama Yap</button>
    </div>
  </form>
</template>


<script>
export default {
  name: "SearchForm",
  data(){
    return{
      selectedItem: 'Null',
      secondSelectedItem: '',
      items: [
        'İstanbul', 'Ankara','İzmir'
      ],
      differentItem: [
        {name:'Sarıyer', city:'İstanbul', number:1},
        {name:'Beşiktaş', city:'İstanbul', number:2},
        {name:'Üsküdar', city:'İstanbul', number:3},
      ]
    }
  },
  methods:{
    search(){
      console.log("Seçtiğiniz il :"+ this.selectedItem);
      console.log("Seçtiğiniz ilçe :"+ this.secondSelectedItem);
    }
  }
}
</script>

<style scoped>

</style>