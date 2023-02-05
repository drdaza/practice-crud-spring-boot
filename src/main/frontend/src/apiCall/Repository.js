import UserRepository from "./UserRepository/UserRepository";
export default class Repository{
    api;
    constructor(api){
        this.api = api;
    }
    chooseApi(){
        if(this.api==='user') return new UserRepository();
    }
}