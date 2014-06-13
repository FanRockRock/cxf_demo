package demo.cxf.rest_spring_cxf_auth;

public class HelloServiceImpl implements HelloService {

    public String say(String name) {
        return "hello " + name;
    }
}
