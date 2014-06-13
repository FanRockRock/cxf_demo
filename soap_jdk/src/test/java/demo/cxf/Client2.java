package demo.cxf;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class Client2 {

    public static void main(String[] args) {
        try {
            URL wsdl = new URL("http://localhost:8080/ws/soap/HelloService?wsdl");
            QName serviceName = new QName("http://cxf.demo/", "HelloService");
            QName portName = new QName("http://cxf.demo/", "HelloServicePort");
            Service service = Service.create(wsdl, serviceName);

            HelloService helloService = service.getPort(portName, HelloService.class);
            String result = helloService.say("world");
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
