package bazy.projekt.app.service;


import bazy.projekt.app.exception.RecordNotFoundException;
import bazy.projekt.app.model.ElectoralRegister;
import bazy.projekt.app.repository.ElectoralRegisterRepository;
import bazy.projekt.app.repository.PersonalDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ElectoralRegisterService {

    private static final String ELECTORAL_REGISTER_NOT_FOUND = "Electoral Register not found!";
    private static final String PERSONAL_DATA_NOT_FOUND = "Personal Data not found!";

    private final ElectoralRegisterRepository electoralRegisterRepository;
    private final PersonalDataRepository personalDataRepository;

    public List<ElectoralRegister> getAll(){
        return electoralRegisterRepository.findAll();
    }

    public List<ElectoralRegister> getAllAfterDate(LocalDate date){
        return electoralRegisterRepository.findAll().stream()
                .filter(n -> n.getDateOfReceipt().isAfter(date))
                .collect(Collectors.toList());
    }

    public List<ElectoralRegister> getAllBeforeDate(LocalDate date){
        return electoralRegisterRepository.findAll().stream()
                .filter(n -> n.getDateOfReceipt().isBefore(date))
                .collect(Collectors.toList());
    }

    public ElectoralRegister getById(Long id){
        try {
            return electoralRegisterRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(ELECTORAL_REGISTER_NOT_FOUND));
        } catch (RecordNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public ElectoralRegister updateRegister(ElectoralRegister electoralRegister){
        return electoralRegisterRepository.saveAndFlush(electoralRegister);
    }

    public ElectoralRegister createRegister(ElectoralRegister electoralRegister, Long id){

        int yearsDifference;

        try {
            yearsDifference = Period.between(personalDataRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(PERSONAL_DATA_NOT_FOUND)).getBirthDate(), LocalDate.now()).getYears();
        } catch (RecordNotFoundException e) {
            throw new RuntimeException(e);
        }

        if(yearsDifference >= 18)
            return electoralRegisterRepository.saveAndFlush(electoralRegister);

        return null;
    }

    public String deleteElectoralRegister(Long id){
        ElectoralRegister registerToDelete = getById(id);
        electoralRegisterRepository.delete(registerToDelete);
        return "Data with id: " + id + " deleted!";
    }
}
