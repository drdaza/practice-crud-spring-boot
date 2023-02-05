<script setup>
import startSesion from '../components/startSesion/startSesion.vue';
import { useRouter } from 'vue-router';
import { passwordStore } from '../stores/passwordStore';
import { ref, computed } from 'vue';

const keywordStore = passwordStore();
const router = useRouter();
let showAlert = ref(false);

const captureEmit = (password)=>{
  keywordStore.asignPasswords();
  if(keywordStore.verifyPasswords(password)) router.push({name:'user', path:'/user'})
  if(!keywordStore.verifyPasswords(password)) showAlert.value = true;
}
const resetinputs = () => {

  showAlert.value = false;
}

const alertZone = computed(()=>{
  return (!showAlert.value) ? 'hidden': 'show';
})

</script>

<template>
  <main>
    <div :class="alertZone">
      <v-alert color="error" title="Error" variant="tonal">
        <p>
          Your password or username are incorrect.
        </p>
    
    
        <v-btn color="error" @click="resetinputs()">
          Okay
        </v-btn>
    
      </v-alert>
    </div>
    <startSesion 
    @valid-emit="captureEmit"/>
  </main>
</template>
<style lang="scss" scoped>
@use '../assets/sass/main' as *;
main{
  @include displayFlex(100%, 95vh, column, center, center);
  .show{
    animation-name: opacitytransition;
    animation-duration: 800ms;
    visibility: visible;
    margin: 1%;
  }
  .hidden{
    visibility: hidden;
    width: 0;
    height: 0;

    overflow: hidden;
  }
}
@keyframes opacitytransition {
    from{
        opacity: 0;
    }
    to{
      opacity: 100;
    }
}
</style>
