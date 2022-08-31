package rs.edu.code.ProjectForComtradeVersion3.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.edu.code.ProjectForComtradeVersion3.model.People;
import rs.edu.code.ProjectForComtradeVersion3.model.Person;
import rs.edu.code.ProjectForComtradeVersion3.service.PeopleService;

import java.util.List;

@RestController
@RequestMapping("/people")
public class PeopleController {

    private final PeopleService peopleService;

    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @PostMapping
    public ResponseEntity<People> create(@RequestBody People people) {
        return ResponseEntity.ok(peopleService.create(people));
    }

    @GetMapping
    public ResponseEntity<List<People>> getAll() {
        return ResponseEntity.ok(peopleService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<People> get(@PathVariable Long id) {
        return ResponseEntity.ok(peopleService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<People> update(@RequestBody People people) {
        return ResponseEntity.ok(peopleService.update(people));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        peopleService.delete(id);
    }












}
