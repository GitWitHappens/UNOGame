package ca.sheridancollege.aldooriy.beans;

public class Card {
    private String color;
    private int number;
    private String action;

    public Card(String color, int number, String action) {
        this.color = color;
        this.number = number;
        this.action = action;
    }

    public String getColor() {
        return color;
    }

    public int getNumber() {
        return number;
    }

    public String getAction() {
        return action;
    }

    public void playCard() {
        // Logic to play the card
    }

    @Override
    public String toString() {
        return "Card{" +
                "color='" + color + '\'' +
                ", number=" + number +
                ", action='" + action + '\'' +
                '}';
    }
}