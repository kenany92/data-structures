package com.kenany.staticarray.tictactoe;

import com.kenany.staticarray.tictactoe.exception.*;

public class Play {

    public static void main(String[] args) {

        TicTacToe game = new TicTacToe();

        FirstPlayerPawn pawn11 = new FirstPlayerPawn();
        FirstPlayerPawn pawn12 = new FirstPlayerPawn();
        FirstPlayerPawn pawn13 = new FirstPlayerPawn();

        SecondPlayerPawn pawn21 = new SecondPlayerPawn();
        SecondPlayerPawn pawn22 = new SecondPlayerPawn();
        SecondPlayerPawn pawn23 = new SecondPlayerPawn();

        try {
            // The first player wins
            game.addPawn(pawn11, 0, 0);
            game.addPawn(pawn21, 1, 0);

            game.addPawn(pawn12, 0, 1);
            game.addPawn(pawn22, 2, 0);

            game.addPawn(pawn13, 0, 2);
            game.addPawn(pawn23, 1, 1);

            game.restart();

            // The second player wins
            game.addPawn(pawn11, 0, 0);
            game.addPawn(pawn21, 1, 1);

            game.addPawn(pawn12, 0, 1);
            game.addPawn(pawn22, 0, 2);

            game.addPawn(pawn13, 1, 0);
            game.addPawn(pawn23, 2, 0);

            game.restart();

            game.addPawn(pawn11, 1, 1);
            game.addPawn(pawn21, 2, 0);

            game.addPawn(pawn12, 1, 2);
            game.addPawn(pawn22, 1, 0);

            game.addPawn(pawn13, 0, 0);
            game.addPawn(pawn23, 0, 2);

            game.bottom(pawn12);
            game.bottom(pawn23);

        } catch (BadPositionException e) {
            System.out.println(e.getMessage());
        } catch (WaitException e) {
            System.out.println(e.getMessage());
        } catch (DuplicatePawnException e) {
            System.out.println(e.getMessage());
        } catch (NotEmptyPositionException e) {
            System.out.println(e.getMessage());
        } catch (GameException e) {
            System.out.println(e.getMessage());
        } catch (BottomMoveException e) {
            System.out.println(e.getMessage());
        } catch (UnknownPawnException e) {
            System.out.println(e.getMessage());
        }
    }
}
