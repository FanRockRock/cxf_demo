package demo.cxf.soap_jdk;

import javax.xml.ws.Endpoint;

public class Server {

    public static void main(String[] args) {
        String address = "http://localhost:8080/HelloService";
        HelloService helloService = new HelloServiceImpl();

        Endpoint.publish(address, helloService);
        System.out.println("web services is published");
    }
}
