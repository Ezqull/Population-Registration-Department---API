package bazy.dziala.bazydziala.service;


import bazy.dziala.bazydziala.model.Application;
import bazy.dziala.bazydziala.repository.ApplicationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicationService {

    private final ApplicationRepository applicationRepository;


    public ApplicationService(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    public List<Application> getAll(){
        return applicationRepository.findAll();
    }

    public Application getById(Long id){
        return applicationRepository.findById(id).orElseThrow();
    }

    public Application updateApplication(Application application){
        Optional<Application> found = applicationRepository.findById(application.getId());
        Application newApplication = found.orElseThrow();
        newApplication.setPersonalData(application.getPersonalData());
        newApplication.setAddress(application.getAddress());
        newApplication.setDateOfApplication(application.getDateOfApplication());
        newApplication.setResult(application.getResult());
        newApplication.setJustification(application.getJustification());
        newApplication.setSubmittingUser(application.getSubmittingUser());
        return applicationRepository.save(newApplication);
    }
    public Application createApplication(Application application){
        return applicationRepository.saveAndFlush(application);
    }

    public String deleteApplication(Long id){
        Application applicationToDelete = getById(id);
        applicationRepository.delete(applicationToDelete);
        return "Data with id: " + id + " deleted!";
    }
}
