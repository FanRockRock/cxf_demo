package demo.cxf.rest_cxf;

import java.util.List;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.junit.Test;

public class JAXRS20ClientTest {

    private static final String baseAddress = "http://localhost:8080/ws/rest";

    private static final JacksonJsonProvider jsonProvider = new JacksonJsonProvider();

    @Test
    public void helloServiceSayTest() {
        String result = ClientBuilder.newClient()
            .target(baseAddress)
            .path("/HelloService")
            .path("/say")
            .queryParam("name", "world")
            .request(MediaType.TEXT_PLAIN)
            .get(String.class);
        System.out.println(result);
    }

    @Test
    public void userServiceRetrieveAllUsersTest() {
        List userList = ClientBuilder.newClient()
            .register(jsonProvider)
            .target(baseAddress)
            .path("/UserService")
            .path("/users")
            .request(MediaType.APPLICATION_JSON)
            .get(List.class);
        for (Object user : userList) {
            System.out.println(JsonUtil.toJSON(user));
        }
    }
}
