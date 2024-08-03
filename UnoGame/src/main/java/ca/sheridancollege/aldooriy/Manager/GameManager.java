package ca.sheridancollege.aldooriy.Manager;

import org.springframework.stereotype.Component;

import ca.sheridancollege.aldooriy.Game.Game;
import ca.sheridancollege.aldooriy.Player.Player;

@Component
public class GameManager {
    private static GameManager instance;
    private Game currentGame;

    private GameManager() {
        currentGame = new Game();
        initializeGame();
    }

    public static GameManager getInstance() {
        if (instance == null) {
            instance = new GameManager();
        }
        return instance;
    }

    private void initializeGame() {
        currentGame.addPlayer(new Player("Alice"));
        currentGame.addPlayer(new Player("Bob"));
        currentGame.addPlayer(new Player("Charlie"));
        currentGame.addPlayer(new Player("Daisy"));
        currentGame.startGame();
    }

    public Game getCurrentGame() {
        return currentGame;
    }

    public void manageGame() {
        while (!currentGame.isGameOver()) {
            Player player = currentGame.getCurrentPlayer();
            System.out.println(player.getName() + "'s turn. Hand: " + player.getHand());
            if (!player.getHand().isEmpty()) {
                player.playCard(player.getHand().get(0));
                currentGame.checkWin();
            }
            currentGame.nextTurn();
        }
    }
}