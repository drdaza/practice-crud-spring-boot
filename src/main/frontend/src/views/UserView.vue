<script setup>
import asideBar from '../components/asideBar/asideBar.vue';
import { RouterView } from 'vue-router';
import { useRoute } from 'vue-router';

const route = useRoute();

let path = route.params.user;
console.log(path);
</script>
<template>
  <main>
    <asideBar :title="`${path}`"/>
    <RouterView />
  </main>
  
</template>

<style lang="scss" scoped>
@use '../assets/sass/main' as *;
main{
  @include displayFlex(100%, 95vh, row, space-around, center);
}
</style>
