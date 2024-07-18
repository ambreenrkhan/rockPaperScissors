package com.game;

public enum PlayerType {
    REAL_PLAYER("Player"),
    COMPUTER_PLAYER("Computer");

    private final String displayName;

    PlayerType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public boolean isComputerPlayer() {
        return this.equals(COMPUTER_PLAYER);
    }
}
