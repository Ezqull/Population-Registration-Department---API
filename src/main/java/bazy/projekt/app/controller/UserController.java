package bazy.projekt.app.controller;

import bazy.projekt.app.model.User;
import bazy.projekt.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/{id}")
    @ResponseBody
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id){
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @GetMapping(path = "/getAll")
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping(path = "/getByEmail/{email}")
    public ResponseEntity<User> getByEmail(@PathVariable("email") String email){
        return ResponseEntity.ok(userService.getUserByEmail(email));
    }

    @PutMapping(path = "/update/{id}", consumes="application/json")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable("id") Long id){
        user.setId(id);
        return ResponseEntity.ok(userService.updateUser(user));
    }

    @PostMapping(path = "/create", consumes="application/json")
    public ResponseEntity<User> createUser(@RequestBody User user){
        return new ResponseEntity(userService.createUser(user), HttpStatusCode.valueOf(201));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id){
        return new ResponseEntity(userService.deleteUser(id), HttpStatusCode.valueOf(204));
    }
}
