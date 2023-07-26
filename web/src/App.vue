<template>
  <NavBar></NavBar>
  <router-view></router-view>
</template>

<script>
import NavBar from './components/NavBar.vue'
import "bootstrap/dist/css/bootstrap.min.css"
import "bootstrap/dist/js/bootstrap"

export default{
  components: {
    NavBar
  },
  
  setup() {
// $.ajax({
//   url: "http://localhost:3000/user/account/token/",
//   type: "post",
//   data: {
//     username: 'gsx3',
//     password: "123456789",
//   },
//   success(resp) {
//     console.log(resp);
//   },
//   error(resp) {
//     console.log(resp);
//   }
// });

// $.ajax({
//   url: "http://127.0.0.1:3000/user/account/info/",
//   type: "get",
//   headers: {
//     Authorization: "Bearer " + "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI1YmQ2MWNkNjFlYzU0ZTU5YjJhY2E1YWQzYjg5ZmRlZiIsInN1YiI6IjEiLCJpc3MiOiJzZyIsImlhdCI6MTY5MDI4NTI2NiwiZXhwIjoxNjkxNDk0ODY2fQ.jLrUU1gieOyYKVXWra_rJQx67kfbu_UT5eQ7us5ZxWM"
//   },
//   success(resp){
//     console.log(resp);
//   },

//   error(resp){
//     console.log(resp);
//   }
// });

//     $.ajax({
//       url: "http://127.0.0.1:3000/user/account/register/",
//       type: "post",
//       data: {
//         username: "gsx3",
//         password: "123456789",
//         confirmedPassword: "123456789",
//       },
//       success(resp) {
//         console.log(resp);
//       },
//       error(resp) {
//         console.log(resp);
//       }
//     })


}

}
</script>

<style>

body {
  background-image: url("@/assets/images/sakura.jpg");
  background-position: center center;
  background-repeat: no-repeat;
  background-attachment: fixed;
  background-size: 100% 100%;
}
 
</style>
