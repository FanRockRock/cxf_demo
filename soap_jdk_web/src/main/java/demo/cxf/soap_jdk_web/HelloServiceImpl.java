package demo.cxf.soap_jdk_web;

import javax.jws.WebService;

@WebService(
    serviceName = "HelloService",
    portName = "HelloServicePort",
    endpointInterface = "demo.cxf.soap_jdk_web.HelloService"
)
public class HelloServiceImpl implements HelloService {

    public String say(String name) {
        return "hello " + name;
    }
}
