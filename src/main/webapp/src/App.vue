<template>
<div><router-link to="/search">Search</router-link>   </div>
<div><router-link to="/create">Create</router-link></div>
  <router-view></router-view>
</template>

<script>

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
}
</script>

<style>
#app{
  font-family: Avenir,Helvetica,Arial,sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #ecd3d3;
  margin-top: 60px;
}
form{
  max-width: 420px;
  margin: 30px auto;
  background: #3b1e6a;
  text-align: left;
  padding: 40px;
  border-radius: 10px;
}
label,option{
  color: #d2c9c9;
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
  color: #090808;
}

button{
  background: #f5ef0c;
  border: 0;
  padding: 10px 20px;
  margin-top: 30px;
  color: #090808;
  border-radius: 20px;
}
.submit{
  text-align: center;
}
.option{
  color: #090808;

}
</style>

