package com.game;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PaperScissorsRockGameTest {

    PaperScissorsRockGame paperScissorsRockGame;
    ConsoleInterface consoleInterface = mock(ConsoleInterface.class);
    @Captor
    ArgumentCaptor<Result> resultCaptor;

    @Before
    public void init() {
        paperScissorsRockGame = new PaperScissorsRockGame(consoleInterface, 2);
    }

    @Test
    public void testGameAttempts() {
        assertEquals(2, paperScissorsRockGame.getGameAttempts());
    }

    @Test
    public void testGameSymbols() {
        assertArrayEquals(new Symbol[]{Symbol.ROCK, Symbol.PAPER, Symbol.SCISSORS},
            paperScissorsRockGame.getSymbols());
    }

    @Test
    public void testGameRules() {
        Player[] players = paperScissorsRockGame.getPlayers();
        assertEquals(2, players.length);

        Player player1 = players[0];
        Player player2 = players[1];

        // tie situation
        player1.setCurrentSymbol(Symbol.ROCK);
        player2.setCurrentSymbol(Symbol.ROCK);
        assertEquals(Optional.empty(), paperScissorsRockGame.applyRules());

        // paper beats rock, player 1 wins
        player1.setCurrentSymbol(Symbol.PAPER);
        player2.setCurrentSymbol(Symbol.ROCK);
        assertEquals(Optional.of(player1), paperScissorsRockGame.applyRules());

        // rock beats scissors, player 1 wins
        player1.setCurrentSymbol(Symbol.ROCK);
        player2.setCurrentSymbol(Symbol.SCISSORS);
        assertEquals(Optional.of(player1), paperScissorsRockGame.applyRules());

        // scissors beat paper, player 2 wins
        player1.setCurrentSymbol(Symbol.PAPER);
        player2.setCurrentSymbol(Symbol.SCISSORS);
        assertEquals(Optional.of(player2), paperScissorsRockGame.applyRules());
    }

    @Test
    public void testGame() {
        when(consoleInterface.selectSymbol(any(), any())).thenReturn(Symbol.PAPER);
        paperScissorsRockGame.start();
        verify(consoleInterface, times(2)).displayResult(resultCaptor.capture());
        Result result = resultCaptor.getValue();
        assertNotNull(result);
    }
}
