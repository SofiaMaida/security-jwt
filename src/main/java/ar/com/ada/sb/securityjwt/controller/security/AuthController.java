package ar.com.ada.sb.securityjwt.controller.security;

import ar.com.ada.sb.securityjwt.model.dto.security.JwtAuthRequestBody;
import ar.com.ada.sb.securityjwt.model.dto.security.JwtAuthResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AuthController {

    public static final Logger LOGGER = LoggerFactory.getLogger(AuthController.class);

    @Value("${auth.jwt.type}")
    private String authJwtType;

    JwtAuthResponseBody token = new JwtAuthResponseBody()
            .setToken("token be here")
            .setType(authJwtType);

    //token.getToken("token");

    @PostMapping({"/login", "/login/"})
    public ResponseEntity createAuthToken(@Valid @RequestBody JwtAuthRequestBody body) {
        LOGGER.info(body.toString());
        //token.getType(authJwtType);

        return ResponseEntity.ok(token);

    }



}
