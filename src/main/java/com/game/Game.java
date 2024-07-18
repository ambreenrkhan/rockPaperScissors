package com.game;

import java.util.Optional;
import java.util.Random;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class Game {

    abstract Symbol[] getSymbols();

    abstract GameInterface getGameInterface();

    abstract int getGameAttempts();

    abstract Player[] getPlayers();

    abstract Optional<Player> applyRules();

    public void start() {
        log.info("Starting game ...");
        GameInterface gameInterface = getGameInterface();
        gameInterface.displayOptions(getSymbols());

        for (int attempt = 1; attempt <= getGameAttempts(); attempt++) {
            Result result = playRound();
            gameInterface.displayResult(result);
        }

        gameInterface.displayFinalScores(getPlayers(), getGameAttempts());
        log.info("Game finished.");
    }

    private Result playRound() {
        for (Player player : getPlayers()) {
            makeMove(player);
        }

        Optional<Player> winnerOptional = applyRules();
        if (winnerOptional.isPresent()) {
            Player winner = winnerOptional.get();
            winner.incrementScore();
            return Result.won(winner);
        }

        return Result.tie();
    }

    private void makeMove(final Player player) {
        final Symbol[] symbols = getSymbols();
        Symbol selectedSymbol;

        if (player.isComputerPlayer()) {
            int symbolIndex = new Random().nextInt(getSymbols().length);
            selectedSymbol = symbols[symbolIndex];
        } else {
            selectedSymbol = getGameInterface().selectSymbol(player, symbols);
        }

        player.setCurrentSymbol(selectedSymbol);
        getGameInterface().displayMove(player, selectedSymbol);
    }

}
