package CustomAuthentication;

import daos.JdbcUserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import pojo.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jordanwanlass on 5/30/17.
 */
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
    /**
     * Authenticates the user when they attempt to login
     * @param authentication Object containing the users inputs
     * @return
     * @throws AuthenticationException
     */
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        ApplicationContext context =
                new ClassPathXmlApplicationContext("/Spring-Module.xml");
        JdbcUserDao userDao = (JdbcUserDao) context.getBean("userDao");
        User user = userDao.getUser(username);
        if(user != null) {
            if(user.getPassword().equals(password)) {
                List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
                grantedAuths.add(new SimpleGrantedAuthority(user.getRole()));// Give them the role of user
                Authentication auth = new UsernamePasswordAuthenticationToken(null, password, grantedAuths);
                return auth;
            }
        } else if("user".equals(username) && "password".equals(password)) {
            List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
            grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));// Give them the role of user
            Authentication auth = new UsernamePasswordAuthenticationToken(null, password, grantedAuths);
            return auth;
        }
        return null;
    }

    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}