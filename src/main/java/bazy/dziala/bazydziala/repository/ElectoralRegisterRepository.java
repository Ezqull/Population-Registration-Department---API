package bazy.dziala.bazydziala.repository;

import bazy.dziala.bazydziala.model.ElectoralRegister;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("electoralRepositoryRegister")
public interface ElectoralRegisterRepository extends JpaRepository<ElectoralRegister, Long> {
    Optional<ElectoralRegister> findById(Long id);
}
