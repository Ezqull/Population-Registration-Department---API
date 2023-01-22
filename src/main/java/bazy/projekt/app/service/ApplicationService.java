package bazy.projekt.app.service;


import bazy.projekt.app.exception.RecordNotFoundException;
import bazy.projekt.app.model.Application;
import bazy.projekt.app.model.Result;
import bazy.projekt.app.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApplicationService {

    private static final String APPLICATION_NOT_FOUND = "Application not found!";
    private final ApplicationRepository applicationRepository;

    @Autowired
    public ApplicationService(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    public List<Application> getAll(){
        return applicationRepository.findAll();
    }

    public List<Application> getAllWaiting(){
        return applicationRepository.findAll().stream()
                .filter(n -> n.getResult() == null)
                .collect(Collectors.toList());
    }

    public List<Application> getAllPositive(){
        return applicationRepository.findAll().stream()
                .filter(n -> n.getResult() == Result.POSITIVE)
                .collect(Collectors.toList());
    }

    public List<Application> getAllNegative(){
        return applicationRepository.findAll().stream()
                .filter(n -> n.getResult() == Result.NEGATIVE)
                .collect(Collectors.toList());
    }

    public List<Application> getAllApplicationsForUser(Long id){
        return applicationRepository.findAll().stream()
                    .filter(n -> n.getSubmittingUser().getId() == id)
                    .collect(Collectors.toList());
    }

    public Application getById(Long id){
        try {
            return applicationRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(APPLICATION_NOT_FOUND));
        } catch (RecordNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Application updateApplication(Application application){
        return applicationRepository.save(application);
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
