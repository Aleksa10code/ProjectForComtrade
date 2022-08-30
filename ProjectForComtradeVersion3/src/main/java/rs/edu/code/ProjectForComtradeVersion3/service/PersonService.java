package rs.edu.code.ProjectForComtradeVersion3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.edu.code.ProjectForComtradeVersion3.dao.PersonRepository;
import rs.edu.code.ProjectForComtradeVersion3.model.Person;

import java.util.List;
import java.util.Set;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public Person create(Person person) {
        return personRepository.save(person);
    }

    public List<Person> getAll() {
        return personRepository.findAll();
    }

    public Person getById(Long id) {
        return personRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Osoba sa ovim id-om " + id + " ne postoji!"));
    }

    public Person update(Person updatePerson) {
        Person dbPerson = getById(updatePerson.getId());
        dbPerson.setFirstName(updatePerson.getFirstName());
        dbPerson.setLastName(updatePerson.getLastName());
        dbPerson.setEmail(updatePerson.getEmail());
        return personRepository.save(dbPerson);
    }

    public void delete(Long id) {
        personRepository.deleteById(id);
    }

}
