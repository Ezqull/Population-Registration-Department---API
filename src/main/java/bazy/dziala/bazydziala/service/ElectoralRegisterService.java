package bazy.dziala.bazydziala.service;


import bazy.dziala.bazydziala.model.CheckedIn;
import bazy.dziala.bazydziala.model.ElectoralRegister;
import bazy.dziala.bazydziala.model.PersonalData;
import bazy.dziala.bazydziala.repository.ElectoralRegisterRepository;
import bazy.dziala.bazydziala.repository.PersonalDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ElectoralRegisterService {

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
        Optional<ElectoralRegister> foundRegister = electoralRegisterRepository.findById(id);
        return foundRegister.orElseThrow();
    }

    public ElectoralRegister updateRegister(ElectoralRegister electoralRegister){
        return electoralRegisterRepository.saveAndFlush(electoralRegister);
    }

    public ElectoralRegister createRegister(ElectoralRegister electoralRegister, Long id){
        int yearsDifference = Period.between(personalDataRepository.findById(id).orElseThrow().getBirthDate(), LocalDate.now()).getYears();
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
