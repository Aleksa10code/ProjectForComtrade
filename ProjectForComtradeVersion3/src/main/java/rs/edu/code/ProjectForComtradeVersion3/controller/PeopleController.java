package rs.edu.code.ProjectForComtradeVersion3.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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




















}
