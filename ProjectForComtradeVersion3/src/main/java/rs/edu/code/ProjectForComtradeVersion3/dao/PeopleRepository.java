package rs.edu.code.ProjectForComtradeVersion3.dao;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import rs.edu.code.ProjectForComtradeVersion3.model.People;
import rs.edu.code.ProjectForComtradeVersion3.model.Person;

import java.util.Set;

public interface PeopleRepository extends JpaRepository<People, Long> {

    @Query("SELECT p from People AS p WHERE ?1 MEMBER OF p.persons")
    Set<People> findAllByHavingPerson(Person person);















}
