package demo.cxf.rest_spring_cxf_shiro;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/UserService")
public interface UserService {

    @POST
    @Path("/authc")
    boolean authc(
        @FormParam("username") String username,
        @FormParam("password") String password
    );
}
