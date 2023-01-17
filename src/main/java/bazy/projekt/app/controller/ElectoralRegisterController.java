package bazy.projekt.app.controller;

import bazy.projekt.app.model.ElectoralRegister;
import bazy.projekt.app.service.ElectoralRegisterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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
    public ResponseEntity<ElectoralRegister> getRegisteredById(@PathVariable("id") Long id){
        return ResponseEntity.ok(electoralRegisterService.getById(id));
    }

    @GetMapping(path = "/getAll")
    public ResponseEntity<List<ElectoralRegister>> getAllRegistered(){
        return ResponseEntity.ok(electoralRegisterService.getAll());
    }

    @GetMapping(path = "/getAllAfterDate/{date}")
    public ResponseEntity<List<ElectoralRegister>> getAllRegisteredAfter(@PathVariable("date") LocalDate date){
        return ResponseEntity.ok(electoralRegisterService.getAllAfterDate(date));
    }

    @GetMapping(path = "/getAllBeforeDate/{date}")
    public ResponseEntity<List<ElectoralRegister>> getAllRegisteredBefore(@PathVariable("date") LocalDate date){
        return ResponseEntity.ok(electoralRegisterService.getAllBeforeDate(date));
    }

    @PutMapping(path = "/update", consumes="application/json")
    public ResponseEntity<ElectoralRegister> updateRegistered(@RequestBody ElectoralRegister electoralRegister){
        return ResponseEntity.ok(electoralRegisterService.updateRegister(electoralRegister));
    }

    @PostMapping(path = "/create", consumes="application/json")
    public ResponseEntity<ElectoralRegister> createRegistered(@RequestBody ElectoralRegister electoralRegister){
        return ResponseEntity.ok(electoralRegisterService.createRegister(electoralRegister, electoralRegister.getPersonalData().getId()));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteRegistered(@PathVariable("id") Long id){
        return ResponseEntity.ok(electoralRegisterService.deleteElectoralRegister(id));
    }
}
