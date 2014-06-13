package demo.cxf.soap_cxf;

import javax.jws.WebService;

@WebService
public interface HelloService {

    String say(String name);
}
