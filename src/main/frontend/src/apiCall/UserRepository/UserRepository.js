import UserPayLoad from "../ApipayLoads/UserPayLoad";
export default class UserRepository{
    url;
    constructor(){
        this.url = 'http://localhost:8080/api/users';
    }
    async getAll(){
        const response = await fetch(this.url, { method: "GET" });

        let json = await response.json();

        let users = [];
        for (const user of json) {
            let temporalUser = new UserPayLoad(user.id, user.username, user.password);

            users.push(temporalUser);
        }
        return users;
    }
    async getOne(){


            const response = await fetch(this.url+'/1', { method: "GET" });
            let element = {}
            if(response.ok) {
                let variable = await response.json();
                element = {
                    id: variable.id,
                    username: variable.username,
                    password: variable.password,
                }
            }
            const data = element;
            /* const data = await response.json(); */
            

            /* let json = await response; */
            
/* 
            let user = [];
            let temporalUser = new UserPayLoad(json.id, json.username, json.password);

            user.push(temporalUser); */
            return data;
          

    }
    
}