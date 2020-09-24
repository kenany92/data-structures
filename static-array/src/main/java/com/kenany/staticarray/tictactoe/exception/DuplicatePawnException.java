package com.kenany.staticarray.tictactoe.exception;

public class DuplicatePawnException extends Exception{

    public DuplicatePawnException(String pawnId) {
        super("The pawn with id: " + pawnId + " already exists in the game");
    }
}
