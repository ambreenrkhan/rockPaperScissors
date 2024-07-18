package com.game;

import java.util.concurrent.atomic.AtomicInteger;

public class PlayerNameProvider {

    private static final AtomicInteger realPlayerCounter = new AtomicInteger();
    private static final AtomicInteger computerPlayerCounter = new AtomicInteger();

    private static PlayerNameProvider instance;

    // Private constructor to prevent external instantiation
    private PlayerNameProvider() {
    }

    public static PlayerNameProvider getInstance() {
        if (instance == null) {
            instance = new PlayerNameProvider();
        }
        return instance;
    }

    public String provideName(final PlayerType playerType) {
        AtomicInteger counter =
            playerType.isComputerPlayer() ? computerPlayerCounter : realPlayerCounter;
        return playerType.getDisplayName() + counter.incrementAndGet();
    }
}
