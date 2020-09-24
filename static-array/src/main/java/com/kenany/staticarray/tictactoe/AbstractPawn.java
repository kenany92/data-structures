package com.kenany.staticarray.tictactoe;

import com.kenany.staticarray.tictactoe.exception.BadPositionException;

import java.util.Objects;
import java.util.UUID;

public abstract class AbstractPawn implements Pawn {

    private final String id = UUID.randomUUID().toString();

    private int posX;

    private int posY;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public int[] getCoord() {
        return new int[] {posX, posY};
    }

    @Override
    public void setCoord(int posX, int posY) throws BadPositionException {
        setPosX(posX);
        setPosY(posY);
    }

    @Override
    public void setPosX(int posX) throws BadPositionException {
        if (posX < 0) {
            throw new BadPositionException();
        }
        this.posX = posX;
    }

    @Override
    public int getPosX() {
        return posX;
    }

    @Override
    public void setPosY(int posY) throws BadPositionException {
        if (posY < 0) {
            throw new BadPositionException();
        }
        this.posY = posY;
    }

    @Override
    public int getPosY() {
        return posY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractPawn that = (AbstractPawn) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
