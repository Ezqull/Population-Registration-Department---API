package bazy.projekt.app.repository;

import bazy.projekt.app.model.Application;
import bazy.projekt.app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("applicationRepository")
public interface ApplicationRepository extends JpaRepository<Application, Long> {

    Optional<Application> findById(Long id);

    @Query("SELECT u FROM User u JOIN FETCH u.applications WHERE u.id = :userId")
    User findByIdWithApplications(@Param("userId") Long userId);
}
