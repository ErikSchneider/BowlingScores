package com.theironyard.controller;

import com.theironyard.entities.Game;
import com.theironyard.entities.User;
import com.theironyard.services.GameRepository;
import com.theironyard.services.UserRepository;
import com.theironyard.utilities.PasswordStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created by Erik on 6/23/16.
 */
@Controller
public class BowlingScoresController {
    @Autowired
    UserRepository users;

    @Autowired
    GameRepository games;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(HttpSession session, Model model) {
        String username = (String) session.getAttribute("username");
        model.addAttribute("username", username);
        model.addAttribute("games", games.findAll());
        return "home";
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(HttpSession session, String username, String password) throws Exception {
        User user = users.findByName(username);
        if (user == null) {
            user = new User(username, PasswordStorage.createHash(password));
            users.save(user);
        }
        else if (!PasswordStorage.verifyPassword(password, user.getPassword())) {
            throw new Exception("Incorrect Password!");
        }
        session.setAttribute("username", username);
        return "redirect:/";
    }

    @RequestMapping(path = "/logout", method = RequestMethod.POST)
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @RequestMapping(path = "/create-game", method = RequestMethod.POST)
    public String createGame(String alley, String score, int strikes, String comment, HttpSession session) {
        String username = (String) session.getAttribute("username");
        User user = users.findByName(username);
        Game g = new Game(alley, score, strikes, comment, user);
        games.save(g);
        return "redirect:/";
    }

    @RequestMapping(path = "/edit-game", method = RequestMethod.POST)
    public String editGame() {
        return "redirect:/";
    }

    @RequestMapping(path = "delete-game", method = RequestMethod.POST)
    public String deleteGame(int id) {
            games.delete(id);
            return "redirect:/";
    }
}
