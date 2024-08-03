package ca.sheridancollege.aldooriy.Action;

import ca.sheridancollege.aldooriy.beans.Card;

public class ActionCard extends Card {
    private String actionType;

    public ActionCard(String color, int number, String action, String actionType) {
        super(color, number, action);
        this.actionType = actionType;
    }

    public String getActionType() {
        return actionType;
    }

    public void executeAction() {
        // Logic to execute the action
    }

    @Override
    public String toString() {
        return "ActionCard{" +
                "actionType='" + actionType + '\'' +
                ", color='" + getColor() + '\'' +
                ", number=" + getNumber() +
                ", action='" + getAction() + '\'' +
                '}';
    }
}
