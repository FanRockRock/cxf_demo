package demo.cxf.rest_cxf;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/UserService")
public class UserService {

    private static final List<User> userList = new ArrayList<User>();

    static {
        userList.add(new User(1, "jack", 20));
        userList.add(new User(2, "rose", 18));
    }

    @GET
    @Path("/users")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> retrieveAllUsers() {
        return userList;
    }

    @GET
    @Path("/user/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User retrieveUserById(long id) {
        User targetUser = null;
        for (User user : userList) {
            if (user.getId() == id) {
                targetUser = user;
                break;
            }
        }
        return targetUser;
    }

    @POST
    @Path("/users")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> retrieveUsersByName(@FormParam("name") String name) {
        List<User> targetUserList = new ArrayList<User>();
        for (User user : userList) {
            if (user.getName().contains(name)) {
                targetUserList.add(user);
            }
        }
        return targetUserList;
    }

    @POST
    @Path("/user")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User createUser(User user) {
        userList.add(user);
        return user;
    }

    @PUT
    @Path("/user/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User updateUserById(long id, Map<String, Object> fieldMap) {
        User user = retrieveUserById(id);
        try {
            for (Map.Entry<String, Object> fieldEntry : fieldMap.entrySet()) {
                Field field = User.class.getDeclaredField(fieldEntry.getKey());
                field.setAccessible(true);
                field.set(user, fieldEntry.getValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @DELETE
    @Path("/user/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> deleteUserById(long id) {
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
