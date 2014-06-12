package demo.cxf.soap_cxf;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

public class Client {

    public static void main(String[] args) {
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setServiceClass(HelloService.class);
        factory.setAddress("http://localhost:8080/ws/HelloService");

        HelloService helloService = factory.create(HelloService.class);
        String result = helloService.say("world");
        System.out.println(result);
    }
}
