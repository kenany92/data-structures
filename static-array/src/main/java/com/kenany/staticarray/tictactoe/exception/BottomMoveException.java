package com.kenany.staticarray.tictactoe.exception;

public class BottomMoveException extends BadMoveException{

    public BottomMoveException() {
        super("This pawn can't move to bottom");
    }
}
