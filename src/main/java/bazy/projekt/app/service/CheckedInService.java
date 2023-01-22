package bazy.projekt.app.service;


import bazy.projekt.app.exception.RecordNotFoundException;
import bazy.projekt.app.model.CheckedIn;
import bazy.projekt.app.repository.CheckedInRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CheckedInService {

    private static final String CHECKED_IN_RECORD_NOT_FOUND = "Checked In record not found!";
    private final CheckedInRepository checkedInRepository;

    @Autowired
    public CheckedInService(CheckedInRepository checkedInRepository) {
        this.checkedInRepository = checkedInRepository;
    }

    public List<CheckedIn> getAll(){
        return checkedInRepository.findAll();
    }

    public CheckedIn getById(Long id){
        try {
            return checkedInRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(CHECKED_IN_RECORD_NOT_FOUND));
        } catch (RecordNotFoundException e) {
            throw new RuntimeException(e);
        }
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
