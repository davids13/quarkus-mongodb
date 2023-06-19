package repoPattern.boundary;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import repoPattern.dao.PersonRepository;
import repoPattern.entity.Person;

import java.net.URI;
import java.util.List;

@ApplicationScoped
@Path("/personsrepopattern")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RepoPersonResource {

   /* @Inject
    PersonService personService;*/

    @Inject
    PersonRepository personRepository;

    @GET
    public List<Person> list() {
        return personRepository.listAll();
    }

    @POST
    public Response create(Person person) {
        if (person == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity(person).build();
        }
        System.out.println(person.name);
        System.out.println(person.age);
        personRepository.persist(person);
        return Response.created(URI.create("/persons/" + person.name)).build();
    }
}
