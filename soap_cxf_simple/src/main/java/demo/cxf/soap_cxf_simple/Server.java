package demo.cxf.soap_cxf_simple;

import org.apache.cxf.frontend.ServerFactoryBean;

public class Server {

    public static void main(String[] args) {
        ServerFactoryBean factory = new ServerFactoryBean();
        factory.setServiceClass(HelloService.class);
        factory.setAddress("http://localhost:8080/ws/HelloService");
        factory.setServiceBean(new HelloServiceImpl());
        factory.create();
        System.out.println("web services is published");
    }
}
