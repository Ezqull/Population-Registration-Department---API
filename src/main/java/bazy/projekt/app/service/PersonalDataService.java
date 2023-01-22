package bazy.projekt.app.service;


import bazy.projekt.app.exception.RecordNotFoundException;
import bazy.projekt.app.model.PersonalData;
import bazy.projekt.app.repository.PersonalDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonalDataService {

    private static final String PERSONAL_DATA_NOT_FOUND = "Personal Data not found!";
    private final PersonalDataRepository personalDataRepository;

    @Autowired
    public PersonalDataService(@Qualifier("personalDataRepository") PersonalDataRepository personalDataRepository) {
        this.personalDataRepository = personalDataRepository;
    }

    public List<PersonalData> getAll(){
        return personalDataRepository.findAll();
    }

    public int countDataAfterBirthDate(LocalDate birthDate){
        return getAll().stream()
                .filter(n -> n.getBirthDate().isAfter(birthDate))
                .collect(Collectors.toList())
                .size();
    }

    public PersonalData getById(Long id){
        try {
            return personalDataRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(PERSONAL_DATA_NOT_FOUND));
        } catch (RecordNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public List<PersonalData> getByLastName(String lastName){
        return personalDataRepository.findAll().stream()
                .filter(n -> n.getLastName().equals(lastName))
                .collect(Collectors.toList());
    }

    public PersonalData getDataByPersonalid(String personalId){
        try {
            return personalDataRepository.findByPersonalId(personalId).orElseThrow(() -> new RecordNotFoundException(PERSONAL_DATA_NOT_FOUND));
        } catch (RecordNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public PersonalData getDataByPassportId(String passportId){
        try {
            return personalDataRepository.findByPassportId(passportId).orElseThrow(() -> new RecordNotFoundException(PERSONAL_DATA_NOT_FOUND));
        } catch (RecordNotFoundException e) {
            throw new RuntimeException(e);
        }
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
