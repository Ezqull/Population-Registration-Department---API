package bazy.dziala.bazydziala.controller;

import bazy.dziala.bazydziala.model.ElectoralRegister;
import bazy.dziala.bazydziala.service.ElectoralRegisterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/electoral-register")
public class ElectoralRegisterController {

    private final ElectoralRegisterService electoralRegisterService;

    public ElectoralRegisterController(ElectoralRegisterService electoralRegisterService) {
        this.electoralRegisterService = electoralRegisterService;
    }

    @GetMapping(path = "/{id}")
    @ResponseBody
    public ResponseEntity<ElectoralRegister> getUserById(@RequestBody @PathVariable("id") Long id){
        return ResponseEntity.ok(electoralRegisterService.getById(id));
    }

    @GetMapping(path = "/getAll")
    public ResponseEntity<List<ElectoralRegister>> getAllUsers(){
        return ResponseEntity.ok(electoralRegisterService.getAll());
    }

    @PutMapping(path = "/update", consumes="application/json")
    public ResponseEntity<ElectoralRegister> updateUser(@RequestBody ElectoralRegister electoralRegister){
        return ResponseEntity.ok(electoralRegisterService.updateRegister(electoralRegister));
    }

    @PostMapping(path = "/create", consumes="application/json")
    public ResponseEntity<ElectoralRegister> createUser(@RequestBody ElectoralRegister electoralRegister){
        return ResponseEntity.ok(electoralRegisterService.createRegister(electoralRegister));
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id){
        return ResponseEntity.ok(electoralRegisterService.deleteElectoralRegister(id));
    }
}
