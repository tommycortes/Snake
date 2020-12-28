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

    Board(int col, int row) {
        board[0] = col;
        board[1] = row;
    }

    //If the snake cell's coordenates are inside the board returns true
    public boolean onBoard(SnakeCell sc) {
        return (((0 <= sc.getSnakeCellCol()) && (sc.getSnakeCellCol() < this.boardCol()))
                && ((0 <= sc.getSnakeCellRow()) && (sc.getSnakeCellRow() < this.boardRow())));
    }

    private int boardCol() {
        return board[0];
    }

    private int boardRow() {
        return board[1];
    }
}
