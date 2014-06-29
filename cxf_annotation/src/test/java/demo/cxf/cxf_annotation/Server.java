package demo.cxf.cxf_annotation;

import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

public class Server {

    public static void main(String[] args) {
        JaxWsServerFactoryBean factory = new JaxWsServerFactoryBean();
        factory.setAddress("http://localhost:8080/ws/soap/hello");
        factory.setServiceClass(HelloService.class);
        factory.setServiceBean(new HelloServiceImpl());
        factory.create();
        System.out.println("soap ws is published");
    }
}
