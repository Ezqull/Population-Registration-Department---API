package bazy.dziala.bazydziala.service;


import bazy.dziala.bazydziala.model.CheckedIn;
import bazy.dziala.bazydziala.repository.CheckedInRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CheckedInService {

    private final CheckedInRepository checkedInRepository;

    @Autowired
    public CheckedInService(CheckedInRepository checkedInRepository) {
        this.checkedInRepository = checkedInRepository;
    }

    public List<CheckedIn> getAll(){
        return checkedInRepository.findAll();
    }

    public CheckedIn getById(Long id){
        Optional<CheckedIn> foundEntity = checkedInRepository.findById(id);
        return foundEntity.orElseThrow();
    }

    public List<CheckedIn> getAllAfterDate(LocalDate date){
        return checkedInRepository.findAll().stream()
                .filter(n -> n.getCheckInDate().isAfter(date))
                .collect(Collectors.toList());
    }

    public List<CheckedIn> getAllBeforeDate(LocalDate date){
        return checkedInRepository.findAll().stream()
                .filter(n -> n.getCheckInDate().isBefore(date))
                .collect(Collectors.toList());
    }

    public CheckedIn updateData(CheckedIn checkedIn){
        return checkedInRepository.save(checkedIn);
    }


    public CheckedIn createData(CheckedIn checkedIn){
        return checkedInRepository.saveAndFlush(checkedIn);
    }

    public String deleteCheckedIn(Long id){
        CheckedIn dataToDelete = getById(id);
        checkedInRepository.delete(dataToDelete);
        return "Data with id: " + id + " deleted!";
    }
}
