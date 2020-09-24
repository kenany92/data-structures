package com.kenany.staticarray.tictactoe.exception;

public class LeftMoveException extends BadMoveException{

    public LeftMoveException() {
        super("This pawn can't move to left");
    }
}
