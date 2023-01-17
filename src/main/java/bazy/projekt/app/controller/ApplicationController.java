package bazy.projekt.app.controller;

import bazy.projekt.app.model.Application;
import bazy.projekt.app.service.ApplicationService;
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
    public ResponseEntity<Application> getApplicationById(@PathVariable("id") Long id){
        return ResponseEntity.ok(applicationService.getById(id));
    }

    @GetMapping(path = "/getAll")
    public ResponseEntity<List<Application>> getAllApplications(){
        return ResponseEntity.ok(applicationService.getAll());
    }

    @GetMapping(path = "/getAllPositive")
    public ResponseEntity<List<Application>> getAllPositiveApplications(){
        return ResponseEntity.ok(applicationService.getAllPositive());
    }

    @GetMapping(path = "/getAllNegative")
    public ResponseEntity<List<Application>> getAllNegativeApplications(){
        return ResponseEntity.ok(applicationService.getAllNegative());
    }

    @GetMapping(path = "/getAllWaiting")
    public ResponseEntity<List<Application>> getAllWaitingApplications(){
        return ResponseEntity.ok(applicationService.getAllWaiting());
    }

    @GetMapping(path = "/getAllForUser/{id}")
    public ResponseEntity<List<Application>> getAllNegativeApplications(@PathVariable("id") Long id){
        return ResponseEntity.ok(applicationService.getAllApplicationsForUser(id));
    }

    @PutMapping(path = "/update", consumes="application/json")
    public ResponseEntity<Application> updateApplication(@RequestBody Application application){
        System.out.println(application);
        return ResponseEntity.ok(applicationService.updateApplication(application));
    }

    @PostMapping(path = "/create", consumes="application/json")
    public ResponseEntity<Application> createApplication(@RequestBody Application application){
        System.out.println(application);
        return ResponseEntity.ok(applicationService.createApplication(application));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteApplication(@RequestBody @PathVariable("id") Long id){
        return ResponseEntity.ok(applicationService.deleteApplication(id));
    }
}
