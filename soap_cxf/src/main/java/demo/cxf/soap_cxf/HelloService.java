package demo.cxf.soap_cxf;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface HelloService {

    String say(@WebParam(name = "name") String name);
}
