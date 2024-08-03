package ca.sheridancollege.aldooriy.Deck;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import ca.sheridancollege.aldooriy.Action.ActionCard;
import ca.sheridancollege.aldooriy.beans.Card;

@JsonIgnoreProperties({"cards"})
public class Deck {
    private List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        initializeDeck();
    }

    private void initializeDeck() {
        // Initialize deck with standard Uno cards
        String[] colors = {"Red", "Blue", "Green", "Yellow"};
        for (String color : colors) {
            for (int i = 0; i <= 9; i++) {
                cards.add(new Card(color, i, null));
                if (i != 0) {
                    cards.add(new Card(color, i, null));
                }
            }
            cards.add(new ActionCard(color, -1, "Skip", "Skip"));
            cards.add(new ActionCard(color, -1, "Reverse", "Reverse"));
            cards.add(new ActionCard(color, -1, "Draw Two", "Draw Two"));
        }
        for (int i = 0; i < 4; i++) {
            cards.add(new ActionCard(null, -1, "Wild", "Wild"));
            cards.add(new ActionCard(null, -1, "Wild Draw Four", "Wild Draw Four"));
        }
        shuffle();
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card drawCard() {
        if (cards.isEmpty()) {
            return null;
        }
        return cards.remove(0);
    }

    @Override
    public String toString() {
        return "Deck{" +
                "cards=" + cards +
                '}';
    }
}