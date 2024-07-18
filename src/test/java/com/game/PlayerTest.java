package com.game;

import static com.game.PlayerType.COMPUTER_PLAYER;
import static com.game.PlayerType.REAL_PLAYER;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PlayerTest {

    @Test
    public void testPlayerScore() {
        Player player1 = new Player("Player1", REAL_PLAYER);
        Player player2 = new Player("Player2", REAL_PLAYER);
        Player player3 = new Player("Computer1", COMPUTER_PLAYER);

        player2.incrementScore();
        player1.incrementScore();
        player1.incrementScore();
        player3.incrementScore();
        player1.incrementScore();
        player2.incrementScore();
        player1.incrementScore();

        assertEquals(4, player1.getScore());
        assertEquals(2, player2.getScore());
        assertEquals(1, player3.getScore());

    }
}
