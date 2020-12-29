/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakeChallenge;

/**
 *
 * @author tommycortes
 */
public class Board {

    int board[] = new int[2];
    
    final int MINBOARD = 1;
    final int MAXBOARD = 20;

    Board(int col, int row) {
        board[0] = col;
        board[1] = row;
        if(!this.isValid()){
            System.err.println("Invalid Board");
        }
    }

    public int boardCol() {
        return board[0];
    }

    public int boardRow() {
        return board[1];
    }
    
    public boolean isValid() {
        return ((MINBOARD <= this.boardCol()) && (this.boardCol() <= MAXBOARD))
                && ((MINBOARD <= this.boardRow()) && (this.boardRow() <= MAXBOARD));
    }
}
