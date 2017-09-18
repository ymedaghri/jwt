package com.ymedaghri.retrogames.resources;

import com.ymedaghri.retrogames.dto.Retrocards;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by medaghrialaouiyoussef on 17/09/2017.
 */
@RestController
@RequestMapping("/api/retrocards")
@Api(value = "RetrocardResourceAPI", produces = MediaType.APPLICATION_JSON_VALUE)
public class RetrocardResource {

    @GetMapping
    @ApiOperation("Retrieves all the retrocards")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Retrocards.class)})
    public Retrocards retrieveRetrocards(){
        Retrocards retrocards=new Retrocards();
        retrocards.entries.add("Everything was good");
        retrocards.entries.add("Indeed very good");
        return retrocards;
    }
}
