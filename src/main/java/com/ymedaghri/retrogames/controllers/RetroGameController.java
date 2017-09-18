package com.ymedaghri.retrogames.controllers;

import com.ymedaghri.retrogames.dto.RetroGame;
import com.ymedaghri.retrogames.repositories.RetroGameRepository;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by medaghrialaouiyoussef on 18/09/2017.
 */
@RestController
@RequestMapping(value = "/api/games", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "retroGames", description = "Operations related to retrospectives games")
public class RetroGameController {

    @Autowired
    private RetroGameRepository retroGameRepository;

    @GetMapping
    @ApiOperation(value = "View a list of all games", authorizations = {@Authorization(value = "Authorization")})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    public Iterable<RetroGame> retrieveGames() {
        Iterable<RetroGame> productList = retroGameRepository.findAll();
        return productList;
    }

    @ApiOperation(value = "Search a game with an ID", response = RetroGame.class)
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public RetroGame showGame(@PathVariable Long id) {
        return retroGameRepository.findOne(id);
    }

    @ApiOperation(value = "Add a game")
    @PostMapping
    public ResponseEntity saveGame(@RequestBody RetroGame game) {
        retroGameRepository.save(game);
        return new ResponseEntity("RetroGame saved successfully", HttpStatus.OK);
    }

    @ApiOperation(value = "Update a game")
    @PutMapping(value = "/{id}")
    public ResponseEntity updateGame(@PathVariable Long id, @RequestBody RetroGame game) {
        RetroGame storedGame = retroGameRepository.findOne(id);
        storedGame.setName(game.getName());
        retroGameRepository.save(storedGame);
        return new ResponseEntity("RetroGame updated successfully", HttpStatus.OK);
    }

    @ApiOperation(value = "Delete a product")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        retroGameRepository.delete(id);
        return new ResponseEntity("RetroGame deleted successfully", HttpStatus.OK);
    }
}
