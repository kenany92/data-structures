package com.kenany.staticarray.tictactoe;

public class EmptyPawn extends AbstractPawn{

    private static final int value = 0;

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public Player getPlayer() {
        return Player.EMPTY;
    }
}
