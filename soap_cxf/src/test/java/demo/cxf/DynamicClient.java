package demo.cxf;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.endpoint.dynamic.DynamicClientFactory;

public class DynamicClient {

    public static void main(String[] args) {
        String wsdl = "http://localhost:8080/ws/soap/HelloService?wsdl";

        DynamicClientFactory factory = DynamicClientFactory.newInstance();
        Client client = factory.createClient(wsdl);

        try {
            Object[] results = client.invoke("say", "world");
            System.out.println(results[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
