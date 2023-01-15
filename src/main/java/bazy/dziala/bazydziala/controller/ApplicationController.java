package bazy.dziala.bazydziala.controller;

import bazy.dziala.bazydziala.model.Application;
import bazy.dziala.bazydziala.service.ApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/application")
public class ApplicationController {

    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping(path = "/{id}")
    @ResponseBody
    public ResponseEntity<Application> getUserById(@RequestBody @PathVariable("id") Long id){
        return ResponseEntity.ok(applicationService.getById(id));
    }

    @GetMapping(path = "/getAll")
    public ResponseEntity<List<Application>> getAllUsers(){
        return ResponseEntity.ok(applicationService.getAll());
    }

    @PutMapping(path = "/update", consumes="application/json")
    public ResponseEntity<Application> updateUser(@RequestBody Application application){
        return ResponseEntity.ok(applicationService.updateApplication(application));
    }

    @PostMapping(path = "/create", consumes="application/json")
    public ResponseEntity<Application> createUser(@RequestBody Application application){
        System.out.println(application.getAddress());
        return ResponseEntity.ok(applicationService.createApplication(application));
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> deleteUser(@RequestBody @PathVariable("id") Long id){
        return ResponseEntity.ok(applicationService.deleteApplication(id));
    }
}
