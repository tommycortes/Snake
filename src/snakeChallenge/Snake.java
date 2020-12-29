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

    public SnakeCell getHead() {
        return snake[0];
    }

    //moves the snake and returns true if is in a valid position
    public boolean moveSnake(Snake s, char dir, Board board) {
        SnakeCell head = s.getHead();
        SnakeCell newHead;
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
                newHead = new SnakeCell(-1, -1);
                break;
        }
        //comentar esta movida
        if (newHead.cellOnBoard(board)) {
            this.moveBody(newHead, s);
            return this.snakeIsValid(board);
        }else{
            return false;
        }
    }

    private void moveBody(SnakeCell newHead, Snake s){
        this.snake[0] = newHead;
            System.out.println(this.snake[0].getSnakeCellCol() + "," + this.snake[0].getSnakeCellRow());
            for (int i = 1; i < snake.length; i++) {
                this.snake[i] = s.getCell(i - 1);
                System.out.println(this.snake[i].getSnakeCellCol() + "," + this.snake[i].getSnakeCellRow());
            }
            System.out.println("--");
    }
    public boolean snakeIsValid(Board board) {
        for (int i = 0; i < snake.length; i++) {
            if(snake[i].cellOverlap(this)||!snake[i].cellOnBoard(board)){
                return false;
            }
        }
        return true;
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
