package com.ymedaghri.retrogames.repositories;

import com.ymedaghri.retrogames.model.RetroGame;
import org.hamcrest.core.Is;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by medaghrialaouiyoussef on 18/09/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RetroGameRepositoryTest {

    @Autowired
    private RetroGameRepository retroGameRepository;

    @Test
    public void testFindByName() throws Exception {
        RetroGame game = retroGameRepository.save(new RetroGame("TeamRocket Sprint 0"));
        assertThat(retroGameRepository.findByName("TeamRocket Sprint 0").getId(), is(game.getId()));

    }
}