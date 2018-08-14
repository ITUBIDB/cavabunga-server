package tr.edu.itu.cavabunga.server.configuration;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Data
public class CavabungaAuthenticationConfiguration {
    private List<String> authenticationMethods = new ArrayList<>();
    private String clientAuthHeaderName;
    private String activeAuthenticationMethod;


    public CavabungaAuthenticationConfiguration(){
        this.authenticationMethods.add("CAVABUNGA");
        this.authenticationMethods.add("DATABASE");
        this.authenticationMethods.add("LDAP");
        this.clientAuthHeaderName = "X-Cavabunga-Client-Token";
        this.activeAuthenticationMethod = "CAVABUNGA";
    }
}
