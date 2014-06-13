package demo.cxf.rest_spring_cxf_shiro;

public class UserServiceImpl implements UserService {

    @Override
    public boolean authc(String username, String password) {
        return username.equals("admin") && password.equals("admin");
    }
}
