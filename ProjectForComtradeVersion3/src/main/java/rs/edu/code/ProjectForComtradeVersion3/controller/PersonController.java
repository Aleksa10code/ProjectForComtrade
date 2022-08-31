package rs.edu.code.ProjectForComtradeVersion3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.edu.code.ProjectForComtradeVersion3.model.Person;
import rs.edu.code.ProjectForComtradeVersion3.service.PeopleService;
import rs.edu.code.ProjectForComtradeVersion3.service.PersonService;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private final PersonService personService;
    private final PeopleService peopleService;

    public PersonController(PersonService personService, PeopleService peopleService) {
        this.personService = personService;
        this.peopleService = peopleService;
    }


    @PostMapping
    public ResponseEntity<Person> create(@RequestBody Person person) {
        return ResponseEntity.ok(personService.create(person));
    }

    @GetMapping
    public ResponseEntity<List<Person>> getAll() {
        return ResponseEntity.ok(personService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> get(@PathVariable Long id) {
        return ResponseEntity.ok(personService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> update(@RequestBody Person person) {
        return ResponseEntity.ok(personService.update(person));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        peopleService.removePersonFromAllPeople(id);
        personService.delete(id);
    }

    //
    @DeleteMapping("/removeFromPeople/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removePersonFromAllPeople(@PathVariable Long id) {
        peopleService.removePersonFromAllPeople(id);
    }


}
