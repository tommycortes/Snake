/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakeChallenge;

/**
 *
 * @author tommycortes
 * 
 * SnakeCell stands for the small parts that form the snake
 */
public class SnakeCell {

    int snakeCell[] = new int[2];

    SnakeCell(int col, int row) {
        snakeCell[0] = col;
        snakeCell[1] = row;
    }
    
    //snake cell's compare
    public boolean equals(SnakeCell s){
        return((snakeCell[0] == s.snakeCellCol()) && (snakeCell[1] == s.snakeCellRow()));
    }
    
    public int snakeCellCol(){
        return snakeCell[0];
    }
    
    public int snakeCellRow(){
        return snakeCell[1];
    }
}
