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
    public ResponseEntity<PersonalData> getDataById(@PathVariable("id") Long id){
        return ResponseEntity.ok(personalDataService.getById(id));
    }

    @GetMapping(path = "/getAll")
    public ResponseEntity<List<PersonalData>> getAll(){
        return ResponseEntity.ok(personalDataService.getAll());
    }

    @GetMapping(path = "/getAllByLastName")
    public ResponseEntity<List<PersonalData>> getAllByLastName(@RequestBody String lastName){
        return ResponseEntity.ok(personalDataService.getByLastName(lastName));
    }

    @GetMapping(path = "/getAllByPersonalId")
    public ResponseEntity<PersonalData> getAllByPersonalId(@RequestBody String personalId){
        return ResponseEntity.ok(personalDataService.getDataByPersonalid(personalId));
    }

    @GetMapping(path = "/getAllByPassport")
    public ResponseEntity<PersonalData> getAllByPassportId(@RequestBody String passportId){
        return ResponseEntity.ok(personalDataService.getDataByPassportId(passportId));
    }

    @PutMapping(path = "/update", consumes="application/json")
    public ResponseEntity<PersonalData> updateData(@RequestBody PersonalData personalData){
        return ResponseEntity.ok(personalDataService.updateData(personalData));
    }

    @PostMapping(path = "/create", consumes="application/json")
    public ResponseEntity<PersonalData> createData(@RequestBody PersonalData personalData){
        return ResponseEntity.ok(personalDataService.createData(personalData));
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> deleteData(@PathVariable("id") Long id){
        return ResponseEntity.ok(personalDataService.deletePersonalData(id));
    }
}
