package demo.cxf.soap_spring_cxf_servlet;

import javax.jws.WebService;

@WebService
public interface HelloService {

    String say(String name);
}
