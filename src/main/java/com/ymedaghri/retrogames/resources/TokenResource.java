package com.ymedaghri.retrogames.resources;

import com.ymedaghri.retrogames.dto.Retrocards;
import com.ymedaghri.retrogames.security.JwtGenerator;
import com.ymedaghri.retrogames.security.JwtUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
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
public class TokenResource {

    private JwtGenerator jwtGenerator;

    public TokenResource(final JwtGenerator jwtGenerator) {
        this.jwtGenerator = jwtGenerator;
    }

    @PostMapping()
    public String generate(@RequestBody final JwtUser jwtUser) {
        return jwtGenerator.generate(jwtUser);
    }
}
