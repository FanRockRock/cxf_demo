package demo.cxf.rest_spring_cxf_shiro;

import java.util.List;
import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import static javax.ws.rs.core.MediaType.*;

@Path("/ProductService")
public interface ProductService {

    @GET
    @Path("/products")
    @Produces(APPLICATION_JSON)
    @RequiresPermissions("product.r")
    List<Product> retrieveAllProducts();

    @GET
    @Path("/product/{id}")
    @Produces(APPLICATION_JSON)
    @RequiresPermissions("product.r")
    Product retrieveProductById(@PathParam("id") long id);

    @POST
    @Path("/products")
    @Consumes(APPLICATION_FORM_URLENCODED)
    @Produces(APPLICATION_JSON)
    @RequiresPermissions("product.r")
    List<Product> retrieveProductsByName(@FormParam("name") String name);

    @POST
    @Path("/product")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @RequiresPermissions("product.c")
    Product createProduct(Product product);

    @PUT
    @Path("/product/{id}")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @RequiresPermissions("product.u")
    Product updateProductById(@PathParam("id") long id, Map<String, Object> fieldMap);

    @DELETE
    @Path("/product/{id}")
    @RequiresPermissions("product.d")
    void deleteProductById(@PathParam("id") long id);
}
