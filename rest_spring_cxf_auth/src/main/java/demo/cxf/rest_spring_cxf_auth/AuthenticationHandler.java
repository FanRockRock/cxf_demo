package demo.cxf.rest_spring_cxf_auth;

import java.io.IOException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import org.apache.cxf.configuration.security.AuthorizationPolicy;
import org.apache.cxf.jaxrs.utils.JAXRSUtils;
import org.apache.cxf.message.Message;

public class AuthenticationHandler implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        Message message = JAXRSUtils.getCurrentMessage();
        AuthorizationPolicy policy = message.get(AuthorizationPolicy.class);
        if (policy == null) {
            login(requestContext);
        } else {
            String username = policy.getUserName();
            String password = policy.getPassword();
            if (!isAuthenticated(username, password)) {
                login(requestContext);
            }
        }
    }

    private void login(ContainerRequestContext requestContext) {
        // 使用 Basic 认证
        requestContext.abortWith(
            Response
                .status(401)
                .header("WWW-Authenticate", "Basic realm=\"CXF Demo\"")
                .build()
        );
    }

    private boolean isAuthenticated(String username, String password) {
        // 模拟用户身份认证
        return username.equals("admin") && password.equals("admin");
    }
}