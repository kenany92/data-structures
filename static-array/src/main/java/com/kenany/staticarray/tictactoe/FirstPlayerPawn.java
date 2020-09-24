package com.kenany.staticarray.tictactoe;

public class FirstPlayerPawn extends AbstractPawn{

    private static final int value = 1;

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public Player getPlayer() {
        return Player.FIRST;
    }
}
