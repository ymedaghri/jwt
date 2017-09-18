package com.ymedaghri.retrogames.resources;

import com.ymedaghri.retrogames.dto.Retrocards;
import io.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by medaghrialaouiyoussef on 17/09/2017.
 */
@RestController
@RequestMapping(value="/api/retrocards", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "RetrocardResourceAPI", description = "Operations related to retrospectives games Cards")
public class RetrocardResource {

    @GetMapping
    @ApiOperation(value = "Retrieves all the retrocards", authorizations = {@Authorization(value="Authorization")})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list", response = Retrocards.class),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")

    })
    public Retrocards retrieveRetrocards(){
        Retrocards retrocards=new Retrocards();
        retrocards.entries.add("Everything was good");
        retrocards.entries.add("Indeed very good");
        return retrocards;
    }
}
