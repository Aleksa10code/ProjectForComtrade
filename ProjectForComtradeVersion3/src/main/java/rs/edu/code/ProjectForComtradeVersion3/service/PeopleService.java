package rs.edu.code.ProjectForComtradeVersion3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.edu.code.ProjectForComtradeVersion3.dao.PeopleRepository;
import rs.edu.code.ProjectForComtradeVersion3.dao.PersonRepository;
import rs.edu.code.ProjectForComtradeVersion3.model.People;
import rs.edu.code.ProjectForComtradeVersion3.model.Person;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class PeopleService {

    @Autowired
    PeopleRepository peopleRepository;

    @Autowired
    PersonRepository personRepository;


    public People create(People people) {
        return peopleRepository.save(people);
    }

    public List<People> getAll() {
        return peopleRepository.findAll();
    }

    public People getById(Long id) {
        return peopleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Grupa sa id-em " + id + " ne postoji"));
    }

    public People update(People updateGroup) {
        People dbGroup = getById(updateGroup.getId());
        dbGroup.setName(updateGroup.getName());
        dbGroup.setPersons(updateGroup.getPersons());
        return peopleRepository.save(dbGroup);
    }

    // Delete whole group
    public void delete(Long id) {
        peopleRepository.deleteById(id);
    }

    // Delete 1 person from group
    public void deletePerson(Long peopleId, Long personToBeDeletedId) {
        People people = peopleRepository.findById(peopleId).orElseThrow(() -> (new IllegalArgumentException("Grupa sa id-jem " + peopleId + " ne postoji")));
        people.getPersons().removeIf(person -> person.getId() == personToBeDeletedId);
        peopleRepository.save(people);
    }

    // Delete person from all groups
    public void removePersonFromAllPeople(Long personId) {
        Person person = personRepository.findById(personId).orElseThrow();
        Set<People> peopleSet = peopleRepository.findAllByHavingPerson(person);
        peopleSet.forEach(people -> people.getPersons().remove(person));
        peopleRepository.saveAll(peopleSet);
    }


}
