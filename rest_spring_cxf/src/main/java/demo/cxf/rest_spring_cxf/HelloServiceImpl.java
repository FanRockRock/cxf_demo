package demo.cxf.rest_spring_cxf;

import org.springframework.stereotype.Component;

@Component
public class HelloServiceImpl implements HelloService {

    public String say(String name) {
        return "hello " + name;
    }
}
