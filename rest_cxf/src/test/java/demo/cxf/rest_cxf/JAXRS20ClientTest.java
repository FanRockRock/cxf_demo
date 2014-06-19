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
            .path("/hello/say")
            .queryParam("name", "world")
            .request()
            .get(String.class);
        System.out.println(result);
    }

    @Test
    public void productServiceRetrieveAllProductsTest() {
        List productList = ClientBuilder.newClient()
            .register(jsonProvider)
            .target(baseAddress)
            .path("/products")
            .request(MediaType.APPLICATION_JSON)
            .get(List.class);
        for (Object product : productList) {
            System.out.println(JsonUtil.toJSON(product));
        }
    }
}
