package bazy.projekt.app.service;


import bazy.projekt.app.model.PersonalData;
import bazy.projekt.app.repository.PersonalDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonalDataService {

    private final PersonalDataRepository personalDataRepository;

    @Autowired
    public PersonalDataService(@Qualifier("personalDataRepository") PersonalDataRepository personalDataRepository) {
        this.personalDataRepository = personalDataRepository;
    }

    public List<PersonalData> getAll(){
        return personalDataRepository.findAll();
    }

    public PersonalData getById(Long id){
        return personalDataRepository.findById(id).orElseThrow();
    }

    public List<PersonalData> getByLastName(String lastName){
        return personalDataRepository.findAll().stream()
                .filter(n -> n.getLastName().equals(lastName))
                .collect(Collectors.toList());
    }

    public PersonalData getDataByPersonalid(String personalId){
        return personalDataRepository.findByPersonalId(personalId)
                .orElseThrow();
    }

    public PersonalData getDataByPassportId(String passportId){
        return personalDataRepository.findByPassportId(passportId)
                .orElseThrow();
    }

    public PersonalData updateData(PersonalData personalData){
        return personalDataRepository.save(personalData);
    }

    public PersonalData createData(PersonalData personalData){
        return personalDataRepository.saveAndFlush(personalData);
    }

    public String deletePersonalData(Long id){
        PersonalData dataToDelete = getById(id);
        personalDataRepository.delete(dataToDelete);
        return "Data with id: " + id + " deleted!";
    }
}
