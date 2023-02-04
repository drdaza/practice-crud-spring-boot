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
      <v-alert
      color="info"
      title="Tonal"
      variant="tonal"
    >
      <p>
        Maecenas nec odio et ante tincidunt tempus. Sed mollis, eros et ultrices tempus, mauris ipsum aliquam libero, non adipiscing dolor urna a orci. Proin viverra, ligula sit amet ultrices semper, ligula arcu tristique sapien, a accumsan nisi mauris ac eros. Curabitur turpis.
      </p>

        
        <v-btn
          color="info"
          @click="resetinputs()"
        >
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
  @include displayFlex(100%, 95vh, row, center, center);
  .show{
    visibility: visible;

  }
  .hidden{
    visibility: hidden;
    width: 0;
    height: 0;

    overflow: hidden;
  }
}
</style>
