<script setup>
import { ref, reactive } from 'vue';
import { userStore } from '../stores/UserStore';
import { onBeforeMount } from 'vue';
import UserPayLoad from '../apiCall/ApipayLoads/UserPayLoad';

const userstore = userStore();
const element = reactive(new UserPayLoad(0,'',''));
onBeforeMount(async() => {
/*   userstore.Asign(); */

console.log( await userstore.getOne());

createTemporal( await userstore.getOne());
})

const createTemporal = (object)=>{
  element.id=object.id;
  element.username=object.username
  element.password=object.password
}




</script>
<template>
    <div class="info">
      <h1>This is {{element.id}} page details</h1>
      <h1>This is {{element.username}} page details</h1>
      <h1>This is {{element.password}} page details</h1>
    </div>
  </template>
  
  <style>
  
  </style>