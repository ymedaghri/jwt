package com.ymedaghri.retrogames.controllers;

import com.ymedaghri.retrogames.security.JwtGenerator;
import com.ymedaghri.retrogames.security.JwtUser;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by medaghrialaouiyoussef on 17/09/2017.
 */
@RestController
@RequestMapping("/token")
@Api(value = "TokenResourceAPI", description = "JWT Login API")
public class TokenController {

    private JwtGenerator jwtGenerator;

    public TokenController(final JwtGenerator jwtGenerator) {
        this.jwtGenerator = jwtGenerator;
    }

    @PostMapping
    public String generate(@RequestBody final JwtUser jwtUser) {
        return jwtGenerator.generate(jwtUser);
    }
}
