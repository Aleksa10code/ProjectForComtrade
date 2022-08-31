package rs.edu.code.ProjectForComtradeVersion3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.edu.code.ProjectForComtradeVersion3.dao.PeopleRepository;
import rs.edu.code.ProjectForComtradeVersion3.model.People;
import rs.edu.code.ProjectForComtradeVersion3.model.Person;

import java.util.List;

@Service
public class PeopleService {

    @Autowired
    PeopleRepository peopleRepository;

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

    public void delete(Long id) {
        peopleRepository.deleteById(id);
    }





}
