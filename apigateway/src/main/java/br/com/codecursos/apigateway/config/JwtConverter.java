package br.com.codecursos.apigateway.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class JwtConverter implements Converter<Jwt, AbstractAuthenticationToken> {


    private JwtGrantedAuthoritiesConverter jwtConvert = new JwtGrantedAuthoritiesConverter();

    @Override
    public AbstractAuthenticationToken convert(Jwt jwt) {

        var authorities = Stream.concat(jwtConvert.convert(jwt).stream(),
                extractRoles(jwt).stream()).collect(Collectors.toSet());

        return new JwtAuthenticationToken(jwt, authorities);
    }

    private Collection<? extends GrantedAuthority> extractRoles(Jwt jwt){
        var roles = new HashSet<>();

        //extração dos roles do realm_access
        var realmRoles = jwt.getClaimAsMap("realm_access");
        if(realmRoles != null && realmRoles.containsKey("roles")){
            roles.addAll((Collection<? extends String>) realmRoles.get("roles"));
        }

        //Extração dos roles do recurso do Code-cursos
        var resourceAccess = jwt.getClaimAsMap("resource_access");
        if(resourceAccess != null && resourceAccess.containsKey("Code-cursos")){
            roles.addAll((Collection<? extends String>) resourceAccess.get("roles"));
        }

        System.out.println("Roles extraidos: " + roles);

        return roles.stream()
                .map(r -> new SimpleGrantedAuthority
                        ("ROLE_" + r.toString().toUpperCase()))
                            .collect(Collectors.toSet());
    }

}
