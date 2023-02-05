<script setup>

import { ref, computed } from 'vue';
const props = defineProps({
    clean:{
        type: Boolean,
        default: false
    }

})
let user = ref('');
let password = ref('');
const emits = defineEmits(['valid-emit']);

const emitValidation = () =>{
    emits('valid-emit',password.value,user.value);
}


</script>
<template>
    <div class="wrapper-inputs">
        <h1>Login</h1>
        <v-text-field label="user" class="format-inputs" v-model="user"  ></v-text-field>
        <v-text-field :type="'password'" label="password" class="format-inputs" v-model="password" ></v-text-field>
        <v-btn
        class="btn-space"
        color="succes"
        size="large"
        @click="emitValidation"
        >
        Start
        </v-btn>
    </div>
</template>
<style lang="scss" scoped>
@use '../../assets/sass/main' as *;
.wrapper-inputs{
    
    @include displayFlex(50%, auto, column, space-around, center );
    background-color: $color-three;
    border-radius: 20px;
    animation-name: example;
    animation-duration: 2s;
    .format-inputs{
        width: 90%;
        background-color: $color-three;
        margin: 1%;
        animation-name: example;
        animation-duration: 2s;
    }
    .btn-space{
        margin: 2%;
    }
}

@keyframes example {
    from{
        background-color: $color-one;
    }
    to{
        background-color: $color-three;
    }
}

</style>