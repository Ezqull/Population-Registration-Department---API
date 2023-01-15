package bazy.dziala.bazydziala.controller;

import bazy.dziala.bazydziala.model.Application;
import bazy.dziala.bazydziala.model.CheckedIn;
import bazy.dziala.bazydziala.service.CheckedInService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/checked-in")
public class CheckedInController {

    private final CheckedInService checkedInService;

    public CheckedInController(CheckedInService checkedInService) {
        this.checkedInService = checkedInService;
    }

    @GetMapping(path = "/{id}")
    @ResponseBody
    public ResponseEntity<CheckedIn> getUserById(@RequestBody @PathVariable("id") Long id){
        return ResponseEntity.ok(checkedInService.getById(id));
    }

    @GetMapping(path = "/getAll")
    public ResponseEntity<List<CheckedIn>> getAllUsers(){
        return ResponseEntity.ok(checkedInService.getAll());
    }

    @PutMapping(path = "/update", consumes="application/json")
    public ResponseEntity<CheckedIn> updateUser(@RequestBody CheckedIn checkedIn){
        return ResponseEntity.ok(checkedInService.updateData(checkedIn));
    }

    @PostMapping(path = "/create", consumes="application/json")
    public ResponseEntity<CheckedIn> createUser(@RequestBody CheckedIn checkedIn){
        return ResponseEntity.ok(checkedInService.createData(checkedIn));
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> deleteUser(@RequestBody @PathVariable("id") Long id){
        return ResponseEntity.ok(checkedInService.deleteCheckedIn(id));
    }
}
