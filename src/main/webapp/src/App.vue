
<template>
<div><router-link to="/search">Search</router-link></div>
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
  color: white;
  margin-top: 0px;
  //background: url(https://getwallpapers.com/wallpaper/full/9/1/5/888848-pink-color-wallpapers-1920x1080-ipad.jpg) no-repeat;
  //background-size: cover;
  background-color: #e5e3e3;

}
form{
  max-width: 420px;
  margin: 30px auto;
  background: #1eb4a9;
  //background: #81624f;
  //background: #d789ad;

  text-align: left;
  padding: 40px;
  border-radius: 10px;

}
label,option{
  color: white;
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
  border-bottom: 1px solid #090808;
  color: #090808;


}

button{
  background: #f5ef0c;
  //background: #d9356e;
  padding: 10px 20px;
  margin-top: 30px;
  color: #090808;
  border-radius: 20px;
}

button:active{
  background-color: #ff3f05;
}

.submit{
  text-align: center;
}
.option{
  color: #350a75;


}
</style>

