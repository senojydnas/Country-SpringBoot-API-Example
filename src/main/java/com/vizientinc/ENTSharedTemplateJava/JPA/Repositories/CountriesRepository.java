package com.vizientinc.ENTSharedTemplateJava.JPA.Repositories;

import com.vizientinc.ENTSharedTemplateJava.JPA.Entities.Country;
import org.hibernate.internal.util.type.PrimitiveWrapperHelper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountriesRepository extends JpaRepository<Country, Integer> {

    @Query(name = "getAllCountries", value = "SELECT * FROM countries", nativeQuery = true)
    List<Country> getAllCountries();

}
