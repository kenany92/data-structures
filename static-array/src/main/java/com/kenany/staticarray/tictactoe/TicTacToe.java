package com.kenany.staticarray.tictactoe;

import com.kenany.staticarray.tictactoe.exception.*;

public class TicTacToe {

    private Player next;

    private boolean canPlay = false;

    private Pawn pawns[][] = new Pawn[3][3];

    private Player winner;

    public TicTacToe() {
        init();
    }

    private void init() {

        canPlay = true;
        winner = null;
        next = null;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                EmptyPawn pawn = new EmptyPawn();
                try {
                    addPawn(pawn, i, j);
                } catch (BadPositionException | WaitException | DuplicatePawnException | NotEmptyPositionException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private Player getNext() {
        return next;
    }

    private void setNext(Pawn pawn) {

        if (pawn.getPlayer() == Player.EMPTY) {
            return;
        }

        this.next = pawn.getPlayer() == Player.FIRST ? Player.SECOND : Player.FIRST;
    }

    /**
     * Add a pawn to the Tictactoe game according to the position (PosX, posY)
     * @param pawn The pawn to add
     * @param posX X axis
     * @param posY Y axis
     * @throws BadPositionException if position if unavailable
     */
    public void addPawn(Pawn pawn, int posX, int posY) throws BadPositionException, WaitException, DuplicatePawnException, NotEmptyPositionException {

        if (!canPlay) {
            System.out.println("The game is over");
            if (winner != Player.EMPTY) {
                System.out.println("The winner is: " + winner + " player");
            } else {
                System.out.println("This is a draw game!");
            }
            return;
        }

        if (pawn == null) {
            return;
        }

        if (posX < 0 || posY < 0 || posX > 2 || posY > 2) {
            throw new BadPositionException();
        }

        if (exists(pawn)) {
            throw new DuplicatePawnException(pawn.getId());
        }

        if (!isEmptyPosition(posX, posY) && pawn.getPlayer() != Player.EMPTY) {
            throw new NotEmptyPositionException(posX, posY);
        }

        if (next != null && pawn.getPlayer() != Player.EMPTY && pawn.getPlayer() != next) {
            throw new WaitException();
        }else {
            pawns[posX][posY] = pawn;
            pawn.setCoord(posX, posY);
            setNext(pawn);

            if (hasWins(pawn)) {
                gameOver(pawn.getPlayer());
            }
        }

    }

    /**
     * Move pawn to left
     * @param pawn the pawn which should move
     * @throws LeftMoveException if isn't possible to move to left
     * @throws UnknownPawnException if pawn isn't found
     */
    public void left(Pawn pawn) throws LeftMoveException, UnknownPawnException, WaitException, GameException {

        if (!exists(pawn)) {
            throw new UnknownPawnException(pawn.getId());
        }

        int posX = pawn.getPosX();
        int posY = pawn.getPosY();

        try {
            move(pawn, posX, posY - 1);
        } catch (BadMoveException e) {
            throw new LeftMoveException();
        }
    }

    /**
     * Move the pawn to rigth
     * @param pawn to move
     * @throws RightMoveException if isn't possible to move to rigth
     * @throws UnknownPawnException if pawn isn't found
     */
    public void rigth(Pawn pawn) throws RightMoveException, UnknownPawnException, WaitException, GameException {

        if (!exists(pawn)) {
            throw new UnknownPawnException(pawn.getId());
        }

        int posX = pawn.getPosX();
        int posY = pawn.getPosY();

        try {
            move(pawn, posX, posY + 1);
        } catch (BadMoveException e) {
            throw new RightMoveException();
        }
    }

    /**
     * Move the pawn to top
     * @param pawn to move
     * @throws TopMoveException if isn't possible to move to top
     * @throws UnknownPawnException if pawn isn't fouund
     */
    public void top(Pawn pawn) throws TopMoveException, UnknownPawnException, WaitException, GameException {

        if (!exists(pawn)) {
            throw new UnknownPawnException(pawn.getId());
        }

        int posX = pawn.getPosX();
        int posY = pawn.getPosY();

        try {
            move(pawn, posX - 1, posY);
        } catch (BadMoveException e) {
            throw new TopMoveException();
        }
    }

    /**
     * Move the pawn to bottom
     * @param pawn to move
     * @throws BottomMoveException if isn't possible to move to bottom
     * @throws UnknownPawnException if pawn isn't found;
     */
    public void bottom(Pawn pawn) throws BottomMoveException, UnknownPawnException, WaitException, GameException {

        if (!exists(pawn)) {
            throw new UnknownPawnException(pawn.getId());
        }

        int posX = pawn.getPosX();
        int posY = pawn.getPosY();

        try {
            move(pawn, posX + 1, posY);
        } catch (BadMoveException e) {
            throw new BottomMoveException();
        }
    }

    /**
     * Move the pawn to the position posX and posY
     * @param pawn to move
     * @param posX Xaxis
     * @param posY Yaxis
     * @throws BadMoveException the pawn can't move to the side
     */
    private void move(Pawn pawn, int posX, int posY) throws BadMoveException, WaitException, GameException {

        if (!canPlay) {
            System.out.println("The game is over");
            if (winner != Player.EMPTY) {
                System.out.println("The winner is: " + winner + " player");
            } else {
                System.out.println("This is a draw game!");
            }
            throw new GameException();
        }

        if (next != null && pawn.getPlayer() != Player.EMPTY && pawn.getPlayer() != next) {
            throw new WaitException();
        }

        if (posX < 0 || posX > 2 || posY < 0 || posY > 2) {
            throw new BadMoveException();
        }

        Pawn existing = pawns[posX][posY];

        if (existing != null && existing.getPlayer() != Player.EMPTY) {
            throw new BadMoveException();
        }

        int pawnX = pawn.getPosX();
        int pawnY = pawn.getPosY();

        try {
            pawn.setCoord(posX, posY);
            pawns[posX][posY] = pawn;

            existing.setCoord(pawnX, pawnY);
            pawns[pawnX][pawnY] = existing;

            setNext(pawn);

            if (hasWins(pawn)) {
                gameOver(pawn.getPlayer());
            }
        } catch (BadPositionException e) {
            e.printStackTrace();
        }
    }

    /**
     * Check if the pawn exists in the game
     * @param pawn to check
     * @return true if exists, false if not
     */
    private boolean exists(Pawn pawn) {

        if (pawn == null) {
            return false;
        }

        if (pawn.getPlayer() == Player.EMPTY) {
            return false;
        }

        int posX = pawn.getPosX();
        int posY = pawn.getPosY();

        if (posX >= 3 || posY >= 3) {
            return false;
        }

        Pawn existing = pawns[posX][posY];

        return existing.equals(pawn);
    }

    public boolean hasWins(Pawn pawn) {

        if (pawn.getPlayer() == Player.EMPTY) {
            return false;
        }

        int pawnValue = pawn.getValue();

        for (int i = 0; i < 3; i++) {

            int value = pawns[i][0].getValue() + pawns[i][0].getValue() + pawns[i][2].getValue();

            if (value == pawnValue * 3) {
                return true;
            }
        }

        for (int j = 0; j < 3; j++) {
            int value = pawns[0][j].getValue() + pawns[1][j].getValue() + pawns[2][j].getValue();

            if (value == pawnValue * 3) {
                return true;
            }
        }

        if (pawns[0][0].getValue() + pawns[1][1].getValue() + pawns[2][2].getValue() == pawnValue * 3) {
            return true;
        }

        if (pawns[0][2].getValue() + pawns[1][1].getValue() + pawns[2][0].getValue() == pawnValue * 3) {
            return true;
        }

        return false;
    }

    private boolean isEmptyPosition(int posX, int posY) {
        Pawn pawn = pawns[posX][posY];
        return pawn == null || pawn.getPlayer() == Player.EMPTY;
    }

    private void gameOver(Player player) {
        winner = player;
        if (player != Player.EMPTY) {
            System.out.println("The " + player + " player wins");
        } else {
            System.out.println("Draw game!");
        }

        canPlay = false;
    }

    public void restart() {
        newGame();
    }

    public void newGame() {
        init();
    }
}
