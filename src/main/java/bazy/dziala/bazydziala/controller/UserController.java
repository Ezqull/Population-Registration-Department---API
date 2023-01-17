package bazy.dziala.bazydziala.controller;

import bazy.dziala.bazydziala.model.User;
import bazy.dziala.bazydziala.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<User> getUserById(@RequestBody @PathVariable("id") Long id){
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

    @PutMapping(path = "/update", consumes="application/json")
    public ResponseEntity<User> updateUser(@RequestBody User user){
        return ResponseEntity.ok(userService.updateUser(user));
    }

    @PostMapping(path = "/create", consumes="application/json")
    public ResponseEntity<User> createUser(@RequestBody User user){
        return ResponseEntity.ok(userService.createUser(user));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id){
        return ResponseEntity.ok(userService.deleteUser(id));
    }
}
