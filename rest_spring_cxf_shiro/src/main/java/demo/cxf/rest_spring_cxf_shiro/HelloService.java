package demo.cxf.rest_spring_cxf_shiro;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import org.apache.shiro.authz.annotation.RequiresPermissions;

@Path("/HelloService")
public interface HelloService {

    @GET
    @Path("/say")
    @RequiresPermissions("hello.say")
    String say(@QueryParam("name") String name);
}
