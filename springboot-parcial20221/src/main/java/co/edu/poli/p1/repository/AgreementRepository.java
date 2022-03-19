package co.edu.poli.p1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.poli.p1.model.Agreement;

public interface AgreementRepository extends JpaRepository<Agreement, Long> {

}
