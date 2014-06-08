package demo.cxf.soap_jdk;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class Client {

    public static void main(String[] args) {
        try {
            URL wsdl = new URL("http://localhost:8080/HelloService?wsdl");
            QName serviceName = new QName("http://soap_jdk.cxf.demo/", "HelloServiceImplService");
            QName portName = new QName("http://soap_jdk.cxf.demo/", "HelloServiceImplPort");
            Service service = Service.create(wsdl, serviceName);

            HelloService helloService = service.getPort(portName, HelloService.class);
            String result = helloService.say("world");
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
