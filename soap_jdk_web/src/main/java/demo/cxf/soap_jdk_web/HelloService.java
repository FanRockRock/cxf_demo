package demo.cxf.soap_jdk_web;

import javax.jws.WebService;

@WebService
public interface HelloService {

    String say(String name);
}
