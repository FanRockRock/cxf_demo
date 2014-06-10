package demo.cxf.rest_cxf;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.ws.rs.FormParam;

public class UserServiceImpl implements UserService {

    private static final List<User> userList = new ArrayList<User>();

    static {
        userList.add(new User(1, "jack", 20));
        userList.add(new User(2, "rose", 18));
    }

    @Override
    public List<User> retrieveAllUsers() {
        return userList;
    }

    @Override
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

    @Override
    public List<User> retrieveUsersByName(@FormParam("name") String name) {
        List<User> targetUserList = new ArrayList<User>();
        for (User user : userList) {
            if (user.getName().contains(name))  {
                targetUserList.add(user);
            }
        }
        return targetUserList;
    }

    @Override
    public User createUser(User user) {
        userList.add(user);
        return user;
    }

    @Override
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

    @Override
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
