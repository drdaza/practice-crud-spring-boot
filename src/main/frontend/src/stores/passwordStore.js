
import { defineStore } from 'pinia'

export const passwordStore = defineStore('password', {
    // arrow function recommended for full type inference
    state:()=>({
        passwords: [],
    }),
    actions:{
        asignPasswords(){
            this.passwords.push("1234567daza")
            this.passwords.push("1234567david")
            this.passwords.push("1234567andres")
            this.passwords.push("1234567carlos")
        },
        verifyPasswords(passwordToVerify){
            for (const pass of this.passwords) {
                if(passwordToVerify== pass){
                    return true;
                } 
            }
            return false;
        }
    }
  })