package bazy.dziala.bazydziala.repository;

import bazy.dziala.bazydziala.model.CheckedIn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("checkedInRepository")
public interface CheckedInRepository extends JpaRepository<CheckedIn, Long> {
    Optional<CheckedIn> findById(Long id);
}
