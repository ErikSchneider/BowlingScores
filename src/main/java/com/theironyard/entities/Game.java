package com.theironyard.entities;

import javax.persistence.*;

/**
 * Created by Erik on 6/23/16.
 */
@Entity
@Table(name = "games")
public class Game {
    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false)
    String alley;

    @Column(nullable = false)
    String score;

    @Column(nullable = false)
    int strikes;

    @Column(nullable = false)
    String comment;

    @ManyToOne
    User user;

    public Game() {
    }

    public Game(String alley, String score, int strikes, String comment, User user) {
        this.alley = alley;
        this.score = score;
        this.strikes = strikes;
        this.comment = comment;
        this.user = user;
    }
}
