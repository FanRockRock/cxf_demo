package demo.cxf.rest_cxf;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/UserService")
public class UserService {

    private static final List<User> userList = new ArrayList<User>();

    static {
        userList.add(new User(1, "jack", 20));
        userList.add(new User(2, "rose", 18));
    }

    /**
     * get all users
     */
    @GET
    @Path("/users")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getAllUsers() {
        return userList;
    }

    /**
     * get user by id
     */
    @GET
    @Path("/user/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUserById(@PathParam("id") long id) {
        User targetUser = null;
        for (User user : userList) {
            if (user.getId() == id) {
                targetUser = user;
                break;
            }
        }
        return targetUser;
    }

    /**
     * search users by name
     */
    @POST
    @Path("/users")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> searchUsersByName(@FormParam("name") String name) {
        List<User> targetUserList = new ArrayList<User>();
        for (User user : userList) {
            if (user.getName().contains(name))  {
                targetUserList.add(user);
            }
        }
        return targetUserList;
    }

    /**
     * delete user by id
     */
    @DELETE
    @Path("/user/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> deleteUserById(@PathParam("id") long id) {
        Iterator<User> userIterator = userList.iterator();
        while (userIterator.hasNext()) {
            User user = userIterator.next();
            if (user.getId() == id) {
                userIterator.remove();
                break;
            }
        }
        return userList;
    }
}
