package com.theironyard.services;

import com.theironyard.entities.Game;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Erik on 6/23/16.
 */
public interface GameRepository extends CrudRepository<Game, Integer> {
//    public Iterable<Game> findByLocation (String alley);
//
//    @Query("SELECT g FROM Game g WHERE g.alley LIKE ?1%")
//    public Iterable<Game> searchLocation (String alley);
}
