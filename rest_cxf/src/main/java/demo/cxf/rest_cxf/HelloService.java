package demo.cxf.rest_cxf;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/HelloService")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class HelloService {

    @GET
    @Path("/say")
    public String say(@QueryParam("name") String name) {
        return "hello " + name;
    }
}
