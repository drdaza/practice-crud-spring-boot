<script setup>
import { ref, reactive } from 'vue';
import { userStore } from '../stores/UserStore';
import { onBeforeMount } from 'vue';
import UserPayLoad from '../apiCall/ApipayLoads/UserPayLoad';

const userstore = userStore();
const principalUser = reactive(new UserPayLoad(0,'',''));
onBeforeMount(async() => {
/*   userstore.Asign(); */

console.log( await userstore.getOne());

createTemporal( await userstore.getOne());
})

const createTemporal = (object)=>{
  principalUser.id = object.id;
  principalUser.username = object.username;
  principalUser.password = object.password;
}




</script>
<template>
    <div class="info">
      <h1>This is {{principalUser.id}} page details</h1>
      <h1>This is {{principalUser.username}} page details</h1>
      <h1>This is {{principalUser.password}} page details</h1>
    </div>
  </template>
  
  <style>
  
  </style>