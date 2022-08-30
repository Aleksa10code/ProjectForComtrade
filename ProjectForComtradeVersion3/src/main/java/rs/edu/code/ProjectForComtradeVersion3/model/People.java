package rs.edu.code.ProjectForComtradeVersion3.model;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
public class People {

    @Id
    @GeneratedValue
    private long id;

    @Column(unique = true)
    private String name;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinTable(name = "people_persons",
    joinColumns = {@JoinColumn(name = "people_id", referencedColumnName = "id")},
    inverseJoinColumns = {@JoinColumn(name = "person_id", referencedColumnName = "id")}
    )
    private Set<Person> persons = new LinkedHashSet<>();

    public People() {

    }

    public People(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Person> getPersons() {
        return persons;
    }

    public void setPersons(Set<Person> persons) {
        this.persons = persons;
    }
}
