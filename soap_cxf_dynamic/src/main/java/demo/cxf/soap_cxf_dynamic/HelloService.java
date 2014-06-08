package demo.cxf.soap_cxf_dynamic;

import javax.jws.WebService;

@WebService
public interface HelloService {

    String say(String name);
}
