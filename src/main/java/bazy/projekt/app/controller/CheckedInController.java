package bazy.projekt.app.controller;

import bazy.projekt.app.model.CheckedIn;
import bazy.projekt.app.service.CheckedInService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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
    public ResponseEntity<CheckedIn> getCheckedInById(@PathVariable("id") Long id){
        return ResponseEntity.ok(checkedInService.getById(id));
    }

    @GetMapping(path = "/getAll")
    public ResponseEntity<List<CheckedIn>> getAllCheckedIn(){
        return ResponseEntity.ok(checkedInService.getAll());
    }

    @GetMapping(path = "/getAllAfterDate/{date}")
    public ResponseEntity<List<CheckedIn>> getAllCheckedInAfter(@PathVariable("date") LocalDate date){
        return ResponseEntity.ok(checkedInService.getAllAfterDate(date));
    }

    @GetMapping(path = "/getAllBeforeDate/{date}")
    public ResponseEntity<List<CheckedIn>> getAllCheckedInBefore(@PathVariable("date") LocalDate date){
        return ResponseEntity.ok(checkedInService.getAllBeforeDate(date));
    }

    @PutMapping(path = "/update", consumes="application/json")
    public ResponseEntity<CheckedIn> updateCheckedIn(@RequestBody CheckedIn checkedIn){
        return ResponseEntity.ok(checkedInService.updateData(checkedIn));
    }

    @PostMapping(path = "/create", consumes="application/json")
    public ResponseEntity<CheckedIn> createCheckedIn(@RequestBody CheckedIn checkedIn){
        return ResponseEntity.ok(checkedInService.createData(checkedIn));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteCheckedIn(@PathVariable("id") Long id){
        return ResponseEntity.ok(checkedInService.deleteCheckedIn(id));
    }
}
