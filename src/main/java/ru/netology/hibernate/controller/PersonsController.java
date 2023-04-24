package ru.netology.hibernate.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.netology.hibernate.entity.Persons;
import ru.netology.hibernate.entity.PersonsPrimaryKey;
import ru.netology.hibernate.service.PersonsService;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/persons")
public class PersonsController {

    private PersonsService personsService;

    @GetMapping("/by-city")
    public List<Persons> getPersonsByCity(@RequestParam("city") String city) {
        return personsService.findByCityOfLiving(city);
    }

    @GetMapping("/by-age-desc")
    public List<Persons> getPersonsByAgeDesc(@RequestParam("age") int age) {
        return personsService.findByPersonsPrimaryKeyAgeLessThanOrderByPersonsPrimaryKeyAge(age);
    }

    @GetMapping("/by-name-surname")
    public Optional<List<Persons>> getPersonsByNameAndSurname(@RequestParam("name") String name,
                                                              @RequestParam("surname") String surname) {
        return personsService.findByPersonsPrimaryKeyNameAndPersonsPrimaryKeySurname(name, surname);
    }

    @PostMapping("/create")
    public Persons createPerson(@RequestBody Persons person) {
        return personsService.save(person);
    }

    @GetMapping("/read/by-name-surname-age")
    public Persons getPersonByPrimaryKey(@RequestParam("name") String name,
                                         @RequestParam("surname") String surname,
                                         @RequestParam("age") int age) {
        return personsService.findById(new PersonsPrimaryKey(name, surname, age));
    }

    @PutMapping("/update/{name}/{surname}/{age}")
    public Persons updatePerson(@PathVariable String name,
                                @PathVariable String surname,
                                @PathVariable int age,
                                @RequestBody Persons person) {

        return personsService.update(new PersonsPrimaryKey(name, surname, age), person);
    }

    @DeleteMapping("/delete/{name}/{surname}/{age}")
    public String deletePerson(@PathVariable String name,
                               @PathVariable String surname,
                               @PathVariable int age) {
        return personsService.delete(new PersonsPrimaryKey(name, surname, age));
    }
}
