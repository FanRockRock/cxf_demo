package demo.cxf.soap_cxf;

import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

public class Server {

    public static void main(String[] args) {
        JaxWsServerFactoryBean factory = new JaxWsServerFactoryBean();
        factory.setServiceClass(HelloService.class);
        factory.setAddress("http://localhost:8080/HelloService");
        factory.setServiceBean(new HelloServiceImpl());
        factory.create();
        System.out.println("web services is published");
    }
}
