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

    public boolean headIsValid(SnakeCell head, Board board) {

        boolean b = board.onBoard(head);
        if (b) {
            for (int i = 1; i < snake.length; i++) {
                //System.out.println(head.equals(this.snake[i]));
                if (head.equals(this.snake[i])) {
                    b = false;
                }
            }
        }
        return b;
    }

    public SnakeCell getHead() {
        return snake[0];
    }

    public void setHead(SnakeCell sc) {
        snake[0] = sc;
    }

    //returns the new head only it does a valid move
    public SnakeCell moveHead(char dir, Board board) {
        SnakeCell head = this.getHead();
        SnakeCell newHead = new SnakeCell(-1, -1);
        switch (dir) {
            case 'u'://row--
                newHead = new SnakeCell(head.getSnakeCellCol(), head.getSnakeCellRow() - 1);
                break;
            case 'l'://col --
                newHead = new SnakeCell(head.getSnakeCellCol() - 1, head.getSnakeCellRow());
                break;
            case 'd'://row++
                newHead = new SnakeCell(head.getSnakeCellCol(), head.getSnakeCellRow() + 1);
                break;
            case 'r'://col++
                newHead = new SnakeCell(head.getSnakeCellCol() + 1, head.getSnakeCellRow());
                break;
            default:
                break;
        }
        
        if (headIsValid(newHead, board)) {
            return newHead;
        } else {
            return newHead = new SnakeCell(-1, -1);
        }
    }

    //para el final
    public boolean snakeIsValid() {
        return true;
    }

    public void moveSnake(Snake s, SnakeCell newHead) {
        this.snake[0] = newHead;
        System.out.println(this.snake[0].getSnakeCellCol()+","+this.snake[0].getSnakeCellRow());
        for (int i = 1; i < snake.length; i++) {
            this.snake[i] = s.getCell(i - 1);
            System.out.println(this.snake[i].getSnakeCellCol()+","+this.snake[i].getSnakeCellRow());
        }
    }

    public SnakeCell getCell(int i) {
        return this.snake[i];
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
