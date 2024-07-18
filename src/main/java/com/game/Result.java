package com.game;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Result {

    private enum Status {WON, TIE}

    private final Player winingPlayer;

    private final Status status;

    public Player getWiningPlayer() {
        return winingPlayer;
    }

    public static Result tie() {
        return new Result(null, Status.TIE);
    }

    public static Result won(Player winingPlayer) {
        return new Result(winingPlayer, Status.WON);
    }

    public boolean isTie() {
        return status.equals(Status.TIE);
    }
}
