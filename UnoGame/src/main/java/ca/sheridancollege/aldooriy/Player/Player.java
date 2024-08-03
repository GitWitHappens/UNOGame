package ca.sheridancollege.aldooriy.Player;


import java.util.ArrayList;
import java.util.List;

import ca.sheridancollege.aldooriy.Deck.Deck;
import ca.sheridancollege.aldooriy.beans.Card;

public class Player {
    private String name;
    private List<Card> hand;
    private int score;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public List<Card> getHand() {
        return hand;
    }

    public int getScore() {
        return score;
    }

    public void drawCard(Deck deck) {
        Card card = deck.drawCard();
        if (card != null) {
            hand.add(card);
        }
    }

    public void playCard(Card card) {
        hand.remove(card);
        // Additional logic to play the card
    }

    public void declareUno() {
        if (hand.size() == 1) {
            System.out.println(name + " declares UNO!");
        }
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", hand=" + hand +
                ", score=" + score +
                '}';
    }
}