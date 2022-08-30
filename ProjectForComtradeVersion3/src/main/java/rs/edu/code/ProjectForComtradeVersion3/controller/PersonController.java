package rs.edu.code.ProjectForComtradeVersion3.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.edu.code.ProjectForComtradeVersion3.model.Person;
import rs.edu.code.ProjectForComtradeVersion3.service.PersonService;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
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
        personService.delete(id);
    }

}
