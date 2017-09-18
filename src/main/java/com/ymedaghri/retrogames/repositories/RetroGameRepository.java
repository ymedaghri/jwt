package com.ymedaghri.retrogames.repositories;

import com.ymedaghri.retrogames.dto.RetroGame;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by medaghrialaouiyoussef on 18/09/2017.
 */
public interface RetroGameRepository extends CrudRepository<RetroGame, Long> {

    RetroGame findByName(String name);
}
