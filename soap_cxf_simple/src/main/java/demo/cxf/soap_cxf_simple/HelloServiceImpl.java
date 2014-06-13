package demo.cxf.soap_cxf_simple;

public class HelloServiceImpl implements HelloService {

    public String say(String name) {
        return "hello " + name;
    }
}
