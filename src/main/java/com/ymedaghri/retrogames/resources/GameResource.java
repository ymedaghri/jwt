package com.ymedaghri.retrogames.resources;

import com.ymedaghri.retrogames.dto.RetroGame;
import com.ymedaghri.retrogames.dto.Retrocards;
import io.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by medaghrialaouiyoussef on 18/09/2017.
 */
@RestController
@RequestMapping(value="/api/games", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "GameResourceAPI", description = "Operations related to retrospectives games")
public class GameResource {

    @GetMapping
    @ApiOperation(value = "Retrieves all the games" /*, authorizations = {@Authorization(value="Authorization")}*/)
    public List<RetroGame> retrieveGames(){

        List<RetroGame> games = new ArrayList<>();
        games.add(new RetroGame("12345678", "TeamRocket Sprint 1"));
        games.add(new RetroGame("42151252", "TeamRocket Sprint 2"));
        games.add(new RetroGame("62362362", "TeamRocket Sprint 3"));

        return games;
    }
}
