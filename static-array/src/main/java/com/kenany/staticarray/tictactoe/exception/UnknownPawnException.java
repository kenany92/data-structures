package com.kenany.staticarray.tictactoe.exception;

public class UnknownPawnException extends Exception{

    /**
     *
     * @param pawnId
     */
    public UnknownPawnException(String pawnId) {
        super("Can't find pawn with id " + pawnId);
    }
}
