package com.kenany.staticarray.tictactoe.exception;

public class BadPositionException extends Exception{

    public BadPositionException() {
        super("This position is unavailable");
    }

    public BadPositionException(String s) {
        super(s);
    }
}
