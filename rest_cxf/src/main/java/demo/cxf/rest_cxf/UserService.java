package demo.cxf.rest_cxf;

import java.util.List;
import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/UserService")
public interface UserService {

    @GET
    @Path("/users")
    @Produces(MediaType.APPLICATION_JSON)
    List<User> retrieveAllUsers();

    @GET
    @Path("/user/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    User retrieveUserById(@PathParam("id") long id);

    @POST
    @Path("/users")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    List<User> retrieveUsersByName(@FormParam("name") String name);

    @POST
    @Path("/user")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    User createUser(User user);

    @PUT
    @Path("/user/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    User updateUserById(@PathParam("id") long id, Map<String, Object> fieldMap);

    @DELETE
    @Path("/user/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    List<User> deleteUserById(@PathParam("id") long id);
}
