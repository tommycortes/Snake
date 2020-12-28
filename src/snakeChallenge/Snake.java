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
public class Snake {
    
    SnakeCell[] snake;
    
    Snake(int length) {
        snake = new SnakeCell[length];
    }
    
    public boolean headIsValid(int[] board) {
        boolean b = true;
        for (int i = 1; i < snake.length; i++) {
            if (this.head().equals(snake[i])) {
                b = false;
            }
        }
        return b;
    }
    
    public boolean snakeIsValid() {
        return true;
    }
    
    public SnakeCell head() {
        return snake[0];
    }
    
    public void moveSnake(SnakeCell h, Snake s, char dir) {
        snake[0] = h;
        for (int i = 1; i < snake.length; i++) {
            snake[i] = s.getCell(i - 1);
        }
    }
    
    public SnakeCell getCell(int i) {
        return snake[i];
    }

    //provisional
    public void uploadSnake() {
        snake[0] = new SnakeCell(2, 2);
        snake[1] = new SnakeCell(3, 2);
        snake[2] = new SnakeCell(3, 1);
        snake[3] = new SnakeCell(3, 0);
        snake[4] = new SnakeCell(2, 0);
        snake[5] = new SnakeCell(1, 0);
        snake[6] = new SnakeCell(0, 0);
    }
}
