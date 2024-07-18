package com.game;

import java.util.concurrent.atomic.AtomicInteger;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
public class Player {

    private final AtomicInteger score = new AtomicInteger();
    private final String name;
    private final PlayerType playerType;
    @Setter
    private Symbol currentSymbol;

    public void incrementScore() {
        score.incrementAndGet();
    }

    public int getScore() {
        return score.intValue();
    }

    public boolean beats(final Player otherPlayer) {
        return getCurrentSymbol().beats(otherPlayer.getCurrentSymbol());
    }

    public boolean isComputerPlayer(){
        return getPlayerType().isComputerPlayer();
    }

    public String toString() {
        return name;
    }
}
