package com.kenany.staticarray.tictactoe.exception;

public class GameException extends Exception{

    public GameException() {
        super("You can't play now");
    }
}
