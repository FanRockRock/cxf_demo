package demo.cxf.soap_cxf_simple;

import org.apache.cxf.frontend.ClientProxyFactoryBean;

public class Client {

    public static void main(String[] args) {
        ClientProxyFactoryBean factory = new ClientProxyFactoryBean();
        factory.setAddress("http://localhost:8080/ws/HelloService");
        factory.setServiceClass(HelloService.class);
        HelloService helloService = factory.create(HelloService.class);
        String result = helloService.say("world");
        System.out.println(result);
    }
}
