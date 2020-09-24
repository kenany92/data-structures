package com.kenany.staticarray.tictactoe.exception;

public class TopMoveException extends BadMoveException{

    public TopMoveException() {
        super("This pawn can't move to top");
    }
}
