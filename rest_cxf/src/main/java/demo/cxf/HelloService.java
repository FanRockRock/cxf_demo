package demo.cxf;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("/HelloService")
public interface HelloService {

    @GET
    @Path("/say")
    public String say(@QueryParam("name") String name);
}
