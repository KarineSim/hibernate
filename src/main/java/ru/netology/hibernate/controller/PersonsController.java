package ru.netology.hibernate.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.hibernate.entity.Persons;
import ru.netology.hibernate.repository.PersonsRepository;

import java.util.List;

@AllArgsConstructor
@RestController
public class PersonsController {

    private PersonsRepository personsRepository;

    @GetMapping("/persons/by-city")
    public List<Persons> getProductName(@RequestParam("city") String city) {
        return personsRepository.getPersonsByCity(city);
    }
}
