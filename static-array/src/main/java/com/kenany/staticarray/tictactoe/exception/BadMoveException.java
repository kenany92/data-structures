package com.kenany.staticarray.tictactoe.exception;

public class BadMoveException extends Exception{

    public BadMoveException() {
        super("Impossible to move for this side");
    }

    public BadMoveException(String s) {
        super(s);
    }
}
