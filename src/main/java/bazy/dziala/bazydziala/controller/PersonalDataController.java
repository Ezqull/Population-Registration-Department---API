package bazy.dziala.bazydziala.controller;

import bazy.dziala.bazydziala.model.PersonalData;
import bazy.dziala.bazydziala.service.PersonalDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personal-data")
public class PersonalDataController {

    private final PersonalDataService personalDataService;

    @Autowired
    public PersonalDataController(PersonalDataService personalDataService) {
        this.personalDataService = personalDataService;
    }

    @GetMapping(path = "/{id}")
    @ResponseBody
    public ResponseEntity<PersonalData> getUserById(@PathVariable("id") Long id){
        return ResponseEntity.ok(personalDataService.getById(id));
    }

    @GetMapping(path = "/getAll")
    public ResponseEntity<List<PersonalData>> getAllUsers(){
        return ResponseEntity.ok(personalDataService.getAll());
    }

    @PutMapping(path = "/update", consumes="application/json")
    public ResponseEntity<PersonalData> updateUser(@RequestBody PersonalData personalData){
        return ResponseEntity.ok(personalDataService.updateData(personalData));
    }

    @PostMapping(path = "/create", consumes="application/json")
    public ResponseEntity<PersonalData> createUser(@RequestBody PersonalData personalData){
        return ResponseEntity.ok(personalDataService.createData(personalData));
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> deleteUser(@RequestBody @PathVariable("id") Long id){
        return ResponseEntity.ok(personalDataService.deletePersonalData(id));
    }
}
