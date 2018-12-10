package io.company.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class ApiController extends AbstractController{

    @GetMapping("member")
    public ResponseEntity member(OAuth2Authentication auth) {
        return ResponseEntity.ok(makeResponse(auth));
    }
}
