package com.example.EJS31.shared;


import com.example.EJS31.person.domain.models.Person;
import com.example.EJS31.person.domain.services.PersonI;
import com.example.EJS31.person.infraestructure.dto.PersonOutputDTO;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
@RestController
public class LoginController {

    @Autowired
    PersonI personService;


    @GetMapping("login")
    public ResponseEntity<String> login(@RequestParam("user") String username, @RequestParam("password") String pwd) throws Exception {
        List<PersonOutputDTO> listaPerson = personService.findByUser(username);
        if(listaPerson.size()==0) throw new Exception("Usuario "+username+" no encontrado");
        if(listaPerson.size()>1) throw new Exception("Usuario ambiguo");
        PersonOutputDTO personOutputDTO = listaPerson.get(0);
        String password = personOutputDTO.getPassword();

        if(!pwd.equals(password)) throw new Exception("Password erroneo");
        String rol = (personOutputDTO.getAdmin()) ? "ROLE_ADMIN" : "ROLE_USER";
        return new ResponseEntity<>(getJWTToken(username,rol), HttpStatus.OK);

    }


    private String getJWTToken(String username, String rol) {

        String secretKey = "mySecretKey";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList(rol);

        String token = Jwts
                .builder()
                .setId("softtekJWT")
                .setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();

        return "Bearer " + token;
    }
}
