package repoPattern.dao;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import repoPattern.entity.Person;

@ApplicationScoped
public class PersonRepository implements PanacheMongoRepository<Person> {

}
