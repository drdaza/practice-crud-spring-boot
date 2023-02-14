package comdrdaza.practicecrud.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import comdrdaza.practicecrud.services.UserService;
import comdrdaza.practicecrud.models.User;

@RestController
@RequestMapping(path = "/api/users")
public class UserController {
    private UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("")
    public List<User> listAll(){
        return service.listAllUsers();
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> get(@PathVariable Long id){
        try {
            User userToGet = service.getUser(id);
            return new ResponseEntity<User>(userToGet, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("")
    public void add(@RequestBody User user){
        service.saveUser(user);
    }
    @PutMapping("/{id}")
    public User update(@PathVariable Long id, @RequestBody User user){
        try {
            return service.updateUser(id, user);
        } catch (Exception e) {
            return null;
        }
    }
    @DeleteMapping("/{id}")
    public List<User>  delete(@PathVariable Long id) {

       return  service.deleteUser(id);
    }

}
