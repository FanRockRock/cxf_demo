package demo.cxf.rest_spring_cxf_shiro;

public class HelloServiceImpl implements HelloService {

    public String say(String name) {
        return "hello " + name;
    }
}
