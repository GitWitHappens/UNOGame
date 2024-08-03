package ca.sheridancollege.aldooriy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ca.sheridancollege.aldooriy.Game.Game;
import ca.sheridancollege.aldooriy.Manager.GameManager;
import ca.sheridancollege.aldooriy.Player.Player;
import ca.sheridancollege.aldooriy.beans.Card;

@RestController
@RequestMapping("/api/game")
public class GameController {

    @Autowired
    private GameManager gameManager;

    @GetMapping("/status")
    public Game getGameStatus() {
        return gameManager.getCurrentGame();
    }

    @PostMapping("/playCard")
    public void playCard(@RequestParam String playerName, @RequestParam int cardIndex) {
        Game game = gameManager.getCurrentGame();
        Player player = game.getPlayers().stream()
                .filter(p -> p.getName().equals(playerName))
                .findFirst()
                .orElse(null);

        if (player != null) {
            Card card = player.getHand().get(cardIndex);
            player.playCard(card);
            game.checkWin();
            game.nextTurn();
        }
    }
}