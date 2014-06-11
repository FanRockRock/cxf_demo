package demo.cxf.rest_cxf;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import org.apache.cxf.jaxrs.client.WebClient;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.junit.Test;

public class WebClientTest {

    private static final String baseAddress = "http://localhost:8080";

    private static final List<Object> providerList = new ArrayList<Object>();

    static {
        providerList.add(new JacksonJsonProvider());
    }

    @Test
    public void helloServiceSayTest() {
        String result = WebClient.create(baseAddress)
            .path("/HelloService")
            .path("/say")
            .query("name", "world")
            .accept(MediaType.TEXT_PLAIN)
            .get(String.class);
        System.out.println(result);
    }

    @Test
    public void userServiceRetrieveAllUsersTest() {
        List userList = WebClient.create(baseAddress, providerList)
            .path("/UserService")
            .path("/users")
            .accept(MediaType.APPLICATION_JSON)
            .get(List.class);
        for (Object user : userList) {
            System.out.println(JsonUtil.toJSON(user));
        }
    }

    @Test
    public void userServiceRetrieveAllUsersTest2() {
        List<User> userList = WebClient.create(baseAddress, providerList)
            .path("/UserService")
            .path("/users")
            .accept(MediaType.APPLICATION_JSON)
            .get(new GenericType<List<User>>() {});
        for (User user : userList) {
            System.out.println(JsonUtil.toJSON(user));
        }
    }
}
