<script setup> 
import { useRouter } from 'vue-router';

const router = useRouter();


const props = defineProps({
    title:{
        type: String,
        default: 'carlos'
    }
})
const userInfoShot = () =>{
    router.push({name: 'userInfo', params: {user:props.title}})
}
</script>
<template>
    <div class="wrapper-aside-bar">
        <div class="shot-user-info" @click="userInfoShot()"> 
            <h4>{{title}} info</h4>
        </div>
    </div>
</template>
<style lang="scss" scoped>
@use '../../assets/sass/main' as *;
.wrapper-aside-bar{
    width: 20%;
    height: 70vh;
    background-color: $color-four;
    @include gridDisplay(10,1);
    .shot-user-info{
        @include displayFlex(90%, auto, row, center, center);
        @include border(1,1,1,2);
    }
    .shot-user-info:hover{
        background-color: brown;
    }
}
</style>