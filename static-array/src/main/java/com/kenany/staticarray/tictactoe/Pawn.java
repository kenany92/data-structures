package com.kenany.staticarray.tictactoe;

import com.kenany.staticarray.tictactoe.exception.BadPositionException;

public interface Pawn {

    String getId();

    int getValue();

    Player getPlayer();

    int[] getCoord();

    void setCoord(int posX, int posY) throws BadPositionException;

    void setPosX(int posX) throws BadPositionException;

    int getPosX();

    void setPosY(int posY) throws BadPositionException;

    int getPosY();
}
