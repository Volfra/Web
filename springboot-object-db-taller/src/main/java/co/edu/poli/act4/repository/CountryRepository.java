package co.edu.poli.act4.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.poli.act4.model.Country;

public interface CountryRepository extends JpaRepository<Country, String> {

}

