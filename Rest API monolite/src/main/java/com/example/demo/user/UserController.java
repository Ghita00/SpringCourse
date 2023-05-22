package com.example.demo.user;

import com.example.demo.post.PostModel;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    //class like fake DB, don't use these methods when you use real DB!
    private static List<UserModel> users = new ArrayList<>();

    private UserRepository userRepository;

    UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    static{
        users.add(new UserModel(1, "Giorgio", 20));
        users.add(new UserModel(2, "Luca", 22));
        users.add(new UserModel(3, "Alessio", 18));
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

    //http://localhost:8080/userByVariable?user=1
    @GetMapping(path = "userByVariable", params = "user=1")
    public UserModel getUser1() throws Exception {
        UserModel u = getSingleUser(1);
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

    //api with db connection
    @GetMapping("/db/users")
    public List<UserModel> usersDB(){
        return this.userRepository.findAll();
    }

    @GetMapping("/db/user/{id}")
    public UserModel getUserDB(@PathVariable int id) throws Exception {

        try {
            UserModel u = this.userRepository.findById(id).get();
            return u;
        }
        catch (Exception e){
            throw new Exception("User not found");
        }
    }

    @PostMapping("/db/createUser")
    public void createUserDB(@RequestBody UserModel user){
        this.userRepository.save(user);
    }

    @GetMapping("db/user/{id}/posts")
    public List<PostModel> getUserWithPosts(@PathVariable int id){
        try {
            UserModel u = this.userRepository.findById(id).get();
            return u.getPosts();
        }
        catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
}
