package com.game;

import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.lang.String.format;

public class ConsoleInterface implements GameInterface {

    private final Scanner scanner;

    private static final String OPTIONS_MSG = "Enter %s";
    private static final String INVALID_OPTIONS_MSG = "Invalid option selected";
    private static final String PLAYER_ENTER_MOVE_MSG = "%s enter move:";
    private static final String SYMBOL_DISPLAY = "'%s' for %s";
    private static final String RESULT_TIE_MSG = "It's a tie!";
    private static final String RESULT_WON_MSG = "%s won!";
    private static final String PLAYER_SCORES_MSG = "%s won %s/%s time(s)";
    private static final String FINAL_MSG = "Game Over. %s!";
    private static final String MOVE_MSG = "%s move: %s";

    public ConsoleInterface() {
        scanner = new Scanner(System.in);
    }

    public void displayOptions(final Symbol[] symbols) {
        final String optionMsg = Arrays.stream(symbols)
            .map(symbol -> format(SYMBOL_DISPLAY, symbol.getKey(), symbol.name()))
            .collect(Collectors.joining(", "));
        System.out.printf(OPTIONS_MSG + System.lineSeparator(), optionMsg);
    }

    public Symbol selectSymbol(final Player player, final Symbol[] symbols) {
        Optional<Symbol> symbol;
        while (true) {
            System.out.printf(PLAYER_ENTER_MOVE_MSG, player.getName());
            String symbolKey = scanner.next();
            if (symbolKey.length() != 1) {
                System.out.println(INVALID_OPTIONS_MSG);
                continue;
            }

            symbol = Symbol.fromKey(symbolKey.charAt(0));
            if (symbol.isPresent()) {
                break;
            }

            System.out.println(INVALID_OPTIONS_MSG);
        }

        return symbol.get();
    }

    public void displayMove(final Player player, final Symbol symbol) {
        System.out.printf(MOVE_MSG + System.lineSeparator(), player.getName(), symbol);
    }

    public void displayResult(final Result result) {
        if (result.isTie()) {
            System.out.println(RESULT_TIE_MSG);
        } else {
            System.out.printf(RESULT_WON_MSG + System.lineSeparator(), result.getWiningPlayer());
        }
    }

    public void displayFinalScores(final Player[] players, final int totalAttempts) {
        final String finalScoresMsg = Arrays.stream(players)
            .map(
                player -> format(PLAYER_SCORES_MSG, player.getName(), player.getScore(),
                    totalAttempts))
            .collect(Collectors.joining(", "));
        System.out.printf(FINAL_MSG + System.lineSeparator(), finalScoresMsg);

        scanner.close();
    }
}
