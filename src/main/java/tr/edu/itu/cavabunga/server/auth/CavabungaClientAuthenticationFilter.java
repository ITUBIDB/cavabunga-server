package tr.edu.itu.cavabunga.server.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;
import org.springframework.web.filter.OncePerRequestFilter;
import tr.edu.itu.cavabunga.server.configuration.CavabungaAuthenticationConfiguration;
import tr.edu.itu.cavabunga.server.service.ClientAuthenticationService;
import tr.edu.itu.cavabunga.server.service.ClientAuthorizationService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

@Component
public class CavabungaClientAuthenticationFilter extends GenericFilterBean {
    @Autowired
    private ClientAuthenticationService clientAuthenticationService;

    @Autowired
    private CavabungaAuthenticationConfiguration cavabungaAuthenticationConfiguration;

    @Override
    public void doFilter(ServletRequest request,
                            ServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String clientToken = httpRequest.getHeader(this.cavabungaAuthenticationConfiguration.getClientAuthHeaderName());
        this.clientAuthenticationService.setToken(clientToken);
        this.clientAuthenticationService.authenticateClient();
        System.out.println(clientToken);
        SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken("__client",clientToken, Collections.emptyList()));
        filterChain.doFilter(request, response);
    }
}
