<template>
<search-form></search-form>
</template>

<script>
import SearchForm from "@/components/SearchForm.vue";
export default {
  name: 'App',
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
  components:{
    SearchForm
  }
}
</script>

<style>
#app{
  font-family: Avenir,Helvetica,Arial,sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: black;
  margin-top: 60px;
}
form{
  max-width: 420px;
  margin: 30px auto;
  background: lightgray;
  text-align: left;
  padding: 40px;
  border-radius: 10px;
}
label,option{
  color: gray;
  font-weight: bold;
  display: inline-block;
  margin: 25px 0 15px;
  font-size: 0.8em;
}
select{
  display: block;
  padding: 10px 6px;
  width: 100%;
  box-sizing: border-box;
  border: none;
  border-bottom: 1px solid #ddd;
  color: #555;
}

button{
  background: #aaaaaa;
  border: 0;
  padding: 10px 20px;
  margin-top: 30px;
  color: white;
  border-radius: 20px;
}
.submit{
  text-align: center;
}
</style>

