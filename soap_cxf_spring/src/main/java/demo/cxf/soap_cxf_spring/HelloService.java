package demo.cxf.soap_cxf_spring;

import javax.jws.WebService;

@WebService
public interface HelloService {

    String say(String name);
}
