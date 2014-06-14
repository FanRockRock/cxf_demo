package demo.cxf.rest_cxf;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import org.apache.cxf.jaxrs.client.WebClient;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.junit.Test;

public class WebClientTest {

    private static final String baseAddress = "http://localhost:8080/ws/rest";

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
            .get(String.class);
        System.out.println(result);
    }

    @Test
    public void productServiceRetrieveAllProductsTest() {
        List productList = WebClient.create(baseAddress, providerList)
            .path("/ProductService")
            .path("/products")
            .accept(MediaType.APPLICATION_JSON)
            .get(List.class);
        for (Object product : productList) {
            System.out.println(JsonUtil.toJSON(product));
        }
    }

    @Test
    public void productServiceRetrieveAllProductsTest2() {
        List<Product> productList = WebClient.create(baseAddress, providerList)
            .path("/ProductService")
            .path("/products")
            .accept(MediaType.APPLICATION_JSON)
            .get(new GenericType<List<Product>>() {});
        for (Product product : productList) {
            System.out.println(JsonUtil.toJSON(product));
        }
    }
}
