package bazy.projekt.app.repository;

import bazy.projekt.app.model.CheckedIn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("checkedInRepository")
public interface CheckedInRepository extends JpaRepository<CheckedIn, Long> {
    Optional<CheckedIn> findById(Long id);
}
