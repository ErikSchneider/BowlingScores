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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAlley() {
        return alley;
    }

    public void setAlley(String alley) {
        this.alley = alley;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public int getStrikes() {
        return strikes;
    }

    public void setStrikes(int strikes) {
        this.strikes = strikes;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
