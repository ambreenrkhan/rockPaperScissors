package com.game;

public interface GameInterface {

    void displayOptions(Symbol[] symbols);

    void displayMove(Player player, Symbol symbol);

    void displayResult(Result result);

    void displayFinalScores(Player[] players, int totalAttempts);

    Symbol selectSymbol(Player player, Symbol[] symbols);
}
