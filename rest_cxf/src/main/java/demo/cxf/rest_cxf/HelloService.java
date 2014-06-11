package demo.cxf.rest_cxf;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/HelloService")
public class HelloService {

    @GET
    @Path("/say")
    public String say(String name) {
        return "hello " + name;
    }
}
