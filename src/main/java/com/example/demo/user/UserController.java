package com.example.demo.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    //class like fake DB, don't use these methods when you use real DB!
    private static List<UserModel> users = new ArrayList<>();

    static{
        users.add(new UserModel(1, "Giorgio", LocalDate.now()));
        users.add(new UserModel(2, "Luca", LocalDate.now()));
        users.add(new UserModel(3, "Alessio", LocalDate.now()));
    }

    //private methods with logic
    private UserModel getSingleUser(int id){
        for(int i = 0; i < users.size(); i++){
            if(users.get(i).getId() == id){
                return users.get(i);
            }
        }
        return null;
    }

    //all API
    @GetMapping("/allUsers")
    public List<UserModel> getUsers(){
        return users;
    }

    @GetMapping("/user/{id}")
    public UserModel getUser(@PathVariable int id) throws Exception {
        UserModel u = getSingleUser(id);
        if(u == null)
            throw new Exception("User not found");
        return u;
    }

    @PostMapping("/user")
    public ResponseEntity<UserModel> createUser(@RequestBody UserModel user){
        user.setId(users.size()+1);
        users.add(user);
        //creating path of where is the resource now created
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<UserModel> deleteUser(@PathVariable int id) throws Exception {
        UserModel u = getSingleUser(id);
        if(u == null)
            throw new Exception("User not found");
        users.remove(u);
        return ResponseEntity.created(null).build();
    }
}
