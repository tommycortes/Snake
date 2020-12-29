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
    final int MAXLENGTH = 7;

    Snake(int length) {
        snake = new SnakeCell[length];
    }

    //moves the snake and returns true if is in a valid position
    //input: old snake, direction to move and board
    public boolean moveSnake(Snake s, char dir, Board board) {
        SnakeCell head = s.snake[0];
        SnakeCell newHead;
        switch (dir) {
            case 'u'://row--
                newHead = new SnakeCell(head.getCol(), head.getRow() - 1);
                break;
            case 'l'://col --
                newHead = new SnakeCell(head.getCol() - 1, head.getRow());
                break;
            case 'd'://row++
                newHead = new SnakeCell(head.getCol(), head.getRow() + 1);
                break;
            case 'r'://col++
                newHead = new SnakeCell(head.getCol() + 1, head.getRow());
                break;
            default:
                newHead = new SnakeCell(-1, -1);
                break;
        }
        //comentar esta movida
        if (newHead.cellOnBoard(board)) {
            this.moveBody(newHead, s);
            return this.isValidPosition(board);
        } else {
            return false;
        }
    }

    //moves the snake to the next position from the new head
    //input: new head and old snake
    private void moveBody(SnakeCell newHead, Snake s) {
        this.snake[0] = newHead;
        for (int i = 1; i < snake.length; i++) {
            this.snake[i] = s.snake[i - 1];
        }
    }

    //Check snake constraints
    public boolean isValidPosition(Board board) {
        //Check if the snake overlaps itself or its outside the board
        for (int i = 0; i < snake.length; i++) {
            if (snake[i].cellOverlap(this) || !snake[i].cellOnBoard(board)) {
                return false;
            }
        }
        return true;
    }

    public boolean isValid() {
        //Check max lenght
        if (snake.length > MAXLENGTH) {
            return false;
        }
        //Check adjacency 
        int col, row, nextCol, nextRow;
        for (int i = 0; i < snake.length - 1; i++) {
            col = snake[i].getCol();
            row = snake[i].getRow();
            nextCol = snake[i + 1].getCol();
            nextRow = snake[i + 1].getRow();

            if (col == nextCol) {
                return (((row == (nextRow + 1)) || (row == (nextRow - 1))));
            } else if (row == nextRow) {
                return (((col == (nextCol + 1)) || (col == (nextCol - 1))));
            } else {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        int col, row;
        String s = "[";
        for (int i = 0; i < snake.length; i++) {
            col = snake[i].getCol();
            row = snake[i].getRow();
            s += "[" + col + ", " + row + "],";
        }
        return s += "]";
    }

    public void uploadTest1() {
        //test 1
        snake[0] = new SnakeCell(2, 2);
        snake[1] = new SnakeCell(3, 2);
        snake[2] = new SnakeCell(3, 1);
        snake[3] = new SnakeCell(3, 0);
        snake[4] = new SnakeCell(2, 0);
        snake[5] = new SnakeCell(1, 0);
        snake[6] = new SnakeCell(0, 0);
        if (!this.isValid()) {
            System.err.println("Invalid Snake");
            System.exit(0);
        }
    }

    public void uploadTest2() {
        //test 2
        snake[0] = new SnakeCell(0, 2);
        snake[1] = new SnakeCell(0, 1);
        snake[2] = new SnakeCell(0, 0);
        snake[3] = new SnakeCell(1, 0);
        snake[4] = new SnakeCell(1, 1);
        snake[5] = new SnakeCell(1, 2);
        if (!this.isValid()) {
            System.err.println("Invalid Snake");
            System.exit(0);
        }
    }

    public void uploadTest3() {
        //test 3
        snake[0] = new SnakeCell(5, 5);
        snake[1] = new SnakeCell(5, 4);
        snake[2] = new SnakeCell(4, 4);
        snake[3] = new SnakeCell(4, 5);
        if (!this.isValid()) {
            System.err.println("Invalid Snake");
            System.exit(0);
        }
    }
}
