package com.kenany.staticarray.tictactoe.exception;

public class NotEmptyPositionException extends Exception{

    public NotEmptyPositionException(int posX, int posY) {
        super("The position {x: " + posX + ", y: " + posY +"} it isn't empty");
    }
}
