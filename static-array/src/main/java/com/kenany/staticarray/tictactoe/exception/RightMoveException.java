package com.kenany.staticarray.tictactoe.exception;

public class RightMoveException extends BadMoveException{

    public RightMoveException() {
        super("This pawn can't move to right");
    }
}
