package com.vizientinc.ENTSharedTemplateJava.Services;

import com.vizientinc.ENTSharedTemplateJava.JPA.Entities.Country;
import com.vizientinc.ENTSharedTemplateJava.JPA.Repositories.CountriesRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class CountriesService {

    public final CountriesRepository countriesRepository;

    public List<Country> getAllCountries() {
        return countriesRepository.getAllCountries();
    }

    public Country getAllById(int id) {
        return countriesRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }


    public Country save(Country newCountry) {

        return countriesRepository.save(newCountry);
    }

    public Country update(int id, Country updatedCountry) {
        return countriesRepository.findById(id)
                .map(country -> {
                    country.setName(updatedCountry.getName());
                    return countriesRepository.save(country);
                })
                .orElseGet(() -> {
                    updatedCountry.setId(id);
                    return countriesRepository.save(updatedCountry);
                });
    }

    public void deleteById(int id) {
        countriesRepository.deleteById(id);
    }
}
