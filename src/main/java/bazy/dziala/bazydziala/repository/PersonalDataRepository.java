package bazy.dziala.bazydziala.repository;

import bazy.dziala.bazydziala.model.PersonalData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("personalDataRepository")
public interface PersonalDataRepository extends JpaRepository<PersonalData, Long> {

    Optional<PersonalData> findById(Long id);

    List<PersonalData> findAll();
    Optional<PersonalData> findByPersonalId(String personalId);
    Optional<PersonalData> findByPassportId(String passportId);
}
