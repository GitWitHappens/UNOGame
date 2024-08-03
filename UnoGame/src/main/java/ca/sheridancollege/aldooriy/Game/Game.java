package ca.sheridancollege.aldooriy.Game;


import java.util.ArrayList;
import java.util.List;

import ca.sheridancollege.aldooriy.Deck.Deck;
import ca.sheridancollege.aldooriy.Player.Player;

public class Game {
    private List<Player> players;
    private Deck deck;
    private Player currentPlayer;
    private boolean isGameOver;

    public Game() {
        players = new ArrayList<>();
        deck = new Deck();
        isGameOver = false;
    }

    // Getters for JSON serialization
    public List<Player> getPlayers() {
        return players;
    }

    public Deck getDeck() {
        return deck;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void startGame() {
        deck.shuffle();
        for (Player player : players) {
            for (int i = 0; i < 7; i++) {
                player.drawCard(deck);
            }
        }
        currentPlayer = players.get(0);
    }

    public void nextTurn() {
        int currentIndex = players.indexOf(currentPlayer);
        currentPlayer = players.get((currentIndex + 1) % players.size());
    }

    public void checkWin() {
        for (Player player : players) {
            if (player.getHand().isEmpty()) {
                System.out.println(player.getName() + " wins the game!");
                isGameOver = true;
                return;
            }
        }
    }

    public void endGame() {
        isGameOver = true;
    }

    @Override
    public String toString() {
        return "Game{" +
                "players=" + players +
                ", deck=" + deck +
                ", currentPlayer=" + currentPlayer +
                ", isGameOver=" + isGameOver +
                '}';
    }
}