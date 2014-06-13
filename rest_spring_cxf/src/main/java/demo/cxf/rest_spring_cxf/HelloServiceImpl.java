package demo.cxf.rest_spring_cxf;

public class HelloServiceImpl implements HelloService {

    public String say(String name) {
        return "hello " + name;
    }
}
