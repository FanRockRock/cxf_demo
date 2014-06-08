package demo.cxf.soap_spring_cxf_servlet;

import javax.jws.WebService;
import org.springframework.stereotype.Component;

@Component
@WebService
public class HelloServiceImpl implements HelloService {

    public String say(String name) {
        return "hello " + name;
    }
}
