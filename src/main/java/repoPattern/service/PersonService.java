package repoPattern.service;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import repoPattern.dao.PersonRepository;
import repoPattern.entity.Person;

import java.util.List;

@Stateless
@Transactional
public class PersonService {

    @Inject
    PersonRepository personRepository;

    public List<Person> getAll() {
        return personRepository.listAll();
    }
}
