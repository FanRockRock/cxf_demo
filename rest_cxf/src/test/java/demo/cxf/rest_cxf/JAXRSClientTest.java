package demo.cxf.rest_cxf;

import java.util.ArrayList;
import java.util.List;
import org.apache.cxf.jaxrs.client.JAXRSClientFactory;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.junit.Test;

public class JAXRSClientTest {

    private static final String baseAddress = "http://localhost:8080/ws/rest";

    private static final List<Object> providerList = new ArrayList<Object>();

    static {
        providerList.add(new JacksonJsonProvider());
    }

    @Test
    public void helloServiceSayTest() {
        HelloService helloService = JAXRSClientFactory.create(baseAddress, HelloService.class);
        String result = helloService.say("world");
        System.out.println(result);
    }

    @Test
    public void productServiceRetrieveAllProductsTest() {
        ProductService productService = JAXRSClientFactory.create(baseAddress, ProductService.class, providerList);
        List<Product> productList = productService.retrieveAllProducts();
        for (Product product : productList) {
            System.out.println(JsonUtil.toJSON(product));
        }
    }
}
