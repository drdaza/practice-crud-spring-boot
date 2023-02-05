import UserPayLoad from '../apiCall/ApipayLoads/UserPayLoad'
import Repository from '../apiCall/Repository'
import { defineStore } from 'pinia'

export const userStore = defineStore('user', {
    // arrow function recommended for full type inference
    state:()=>({
        users: [],
        userOne: []
    }),
    actions:{
        async Asign(){
            const api = new Repository('user')
            const reporitory = api.chooseApi();

            const response = await reporitory.getAll();

            this.users = response;

            
        },
        async getOne(){
            const api = new Repository('user')
            const reporitory = api.chooseApi();

            const response = await reporitory.getOne();
            
            return response
            
        },
        
        
    }
  })