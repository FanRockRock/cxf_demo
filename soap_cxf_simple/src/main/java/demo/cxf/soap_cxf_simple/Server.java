package demo.cxf.soap_cxf_simple;

import org.apache.cxf.frontend.ServerFactoryBean;

public class Server {

    public static void main(String[] args) {
        ServerFactoryBean factory = new ServerFactoryBean();
        factory.setAddress("http://localhost:8080/ws/soap/HelloService");
        factory.setServiceClass(HelloService.class);
        factory.setServiceBean(new HelloServiceImpl());
        factory.create();
        System.out.println("soap ws is published");
    }
}
