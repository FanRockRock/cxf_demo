package demo.cxf.soap_spring_cxf_interceptor_annotation;

import javax.jws.WebService;

@WebService
public class HelloServiceImpl implements HelloService {

    public String say(String name) {
        return "hello " + name;
    }
}
