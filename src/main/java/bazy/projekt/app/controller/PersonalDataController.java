package bazy.projekt.app.controller;

import bazy.projekt.app.model.PersonalData;
import bazy.projekt.app.service.PersonalDataService;
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

    @GetMapping(path = "/getAllByLastName/{lastName}")
    public ResponseEntity<List<PersonalData>> getAllByLastName(@PathVariable("lastName") String lastName){
        return ResponseEntity.ok(personalDataService.getByLastName(lastName));
    }

    @GetMapping(path = "/getAllByPersonalId/{personalId}")
    public ResponseEntity<PersonalData> getAllByPersonalId(@PathVariable("personalId") String personalId){
        return ResponseEntity.ok(personalDataService.getDataByPersonalid(personalId));
    }

    @GetMapping(path = "/getAllByPassportId/{passportId}")
    public ResponseEntity<PersonalData> getAllByPassportId(@PathVariable("passportId") String passportId){
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

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteData(@PathVariable("id") Long id){
        return ResponseEntity.ok(personalDataService.deletePersonalData(id));
    }
}
