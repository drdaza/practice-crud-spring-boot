<script setup>
import asideBar from '../components/asideBar/asideBar.vue';
import { RouterView } from 'vue-router';

</script>
<template>
  <main>
    <asideBar :title="'pepe'"/>
    <RouterView />
  </main>
  
</template>

<style lang="scss" scoped>
@use '../assets/sass/main' as *;
main{
  @include displayFlex(100%, 95vh, row, space-around, center);
}
</style>
