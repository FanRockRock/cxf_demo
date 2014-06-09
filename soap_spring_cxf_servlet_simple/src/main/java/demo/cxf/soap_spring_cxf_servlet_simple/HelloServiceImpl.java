package demo.cxf.soap_spring_cxf_servlet_simple;

public class HelloServiceImpl implements HelloService {

    public String say(String name) {
        return "hello " + name;
    }
}
