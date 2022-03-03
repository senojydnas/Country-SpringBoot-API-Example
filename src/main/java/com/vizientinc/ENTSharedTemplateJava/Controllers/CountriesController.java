package com.vizientinc.ENTSharedTemplateJava.Controllers;

import com.vizientinc.ENTSharedTemplateJava.JPA.Entities.Country;
import com.vizientinc.ENTSharedTemplateJava.Services.CountriesService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/countries")
@AllArgsConstructor
public class CountriesController {

    public final CountriesService countriesService;

    @GetMapping()
    public List<Country> getCountries() {
        return countriesService.getAllCountries();
    }

    @GetMapping("/{id}")
    public Country getCountriesById(@PathVariable int id) {
        return countriesService.getAllById(id);
    }

    @PostMapping()
    public Country createNewCountry(@RequestBody Country newCountry) {
        return countriesService.save(newCountry);
    }

    @PutMapping("/{id}")
    public Country updateCountry(@PathVariable int id, @RequestBody Country updatedCountry) {
        return countriesService.update(id, updatedCountry);
    }

    @DeleteMapping("/{id}")
    public void deleteCountry(@PathVariable int id) {
        countriesService.deleteById(id);
    }
 }
