package com.game;


import static com.game.PlayerType.COMPUTER_PLAYER;
import static com.game.PlayerType.REAL_PLAYER;

import java.util.Optional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PaperScissorsRockGame extends Game {

    private final GameInterface gameInterface;
    private final int gameAttempts;
    private Player realPlayer;
    private Player computerPlayer;

    public PaperScissorsRockGame() {
        this(new ConsoleInterface(), 5);
    }

    public PaperScissorsRockGame(final GameInterface gameInterface, final int gameAttempts) {
        this.gameInterface = gameInterface;
        this.gameAttempts = gameAttempts;
        initPlayers();
    }

    private void initPlayers() {
        final String realPlayerName = PlayerNameProvider.getInstance().provideName(REAL_PLAYER);
        realPlayer = new Player(realPlayerName, REAL_PLAYER);

        final String computerPlayerName = PlayerNameProvider.getInstance()
            .provideName(COMPUTER_PLAYER);
        computerPlayer = new Player(computerPlayerName, COMPUTER_PLAYER);

        log.info("Initializing players {} and {}.", realPlayerName, computerPlayerName);
    }

    public Player[] getPlayers() {
        return new Player[]{realPlayer, computerPlayer};
    }

    public Symbol[] getSymbols() {
        return Symbol.values();
    }

    public GameInterface getGameInterface() {
        return gameInterface;
    }

    public int getGameAttempts() {
        return gameAttempts;
    }

    public Optional<Player> applyRules() {
        return realPlayer.beats(computerPlayer) ? Optional.of(realPlayer) :
            computerPlayer.beats(realPlayer) ? Optional.of(computerPlayer) :
                Optional.empty();
    }
}
