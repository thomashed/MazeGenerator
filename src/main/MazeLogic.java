package main;

import java.util.Random;

public class MazeLogic {

    // Fields
    char[][] maze;
    char path;
    char fill;

    int rowValue;
    int colValue;

    // Constructor
    public MazeLogic() {
        this.maze = new char[20][20];

        this.path = '0';
        this.fill = '-';
        this.rowValue = 0;
        this.colValue = 0;
    }

    // Methods
    public void run() {
        fillMaze();
        makePath();
        printMaze();
    }

    private void fillMaze() {
        for (int row = 0; row < maze.length; row++) {
            for (int col = 0; col < maze[0].length; col++) {
                maze[row][col] = fill;
            }
        }
    }

    public void printMaze() {

        for (int row = 0; row < maze.length; row++) {
            for (int col = 0; col < maze[0].length; col++) {
                System.out.print(maze[row][col] + "  ");
            }
            System.out.println();
        }
    }

    public boolean isPlaceValid() {
        if ((rowValue - 1) == 0 || (colValue - 1) == 0 || (colValue + 1) == 19) {
            return false;
        }
        return true;
    }

    private void resetData() {
        maze = null;
    }

    // Path making methods
    private void makePath() {
        Random r = new Random();
        setStartCoordinates();

        while (rowValue != 19) {
            int chooseMovement = r.nextInt(4);

            switch (chooseMovement) {
                case 0:
                    moveUp();
                    break;
                case 1:
                    moveRight();
                    break;
                case 2:
                    moveDown();
                    break;
                default:
                    moveLeft();
                    break;
                    
            }
        }

    }

    private void setStartCoordinates() {
        Random r = new Random();
        colValue = r.nextInt(12) + 4;
        placePath();
        moveDown();
    }

    // MoveMethods
    private void moveUp() {
        if (isPlaceValid()) {
            if (checkSurroundingsUp()) {
                rowValue = rowValue - 1;
                placePath();
            } else {
                // ChangeDirection
            }
        }
    }

    private void moveRight() {
        if (isPlaceValid()) {
            if (checkSurroundingsRight()) {
                colValue = colValue + 1;
                placePath();
            } else {
                // ChangeDirection
            }
        }
    }

    private void moveDown() {
        if (isPlaceValid()) {
            if (checkSurroundingsDown()) {
                rowValue = rowValue + 1;
                placePath();
            } else {
                // ChangeDirection
            }
        }
    }

    private void moveLeft() {
        if (isPlaceValid()) {
            if (checkSurroundingsLeft()) {
                colValue = colValue - 1;
                placePath();
            }
        }
    }

    // checkSurroundings
    private boolean checkSurroundingsUp() {
        int newRow, newCol;
        newRow = rowValue - 1;
        newCol = colValue;

        if (maze[newRow][newCol] == fill && maze[newRow][newCol - 1] == fill && maze[newRow - 1][newCol - 1] == fill && maze[newRow - 1][newCol] == fill && maze[newRow - 1][newCol + 1] == fill && maze[newRow][newCol + 1] == fill) {
            return true;
        } else {
            return false;
        }
    }

    private boolean checkSurroundingsRight() {
        int newRow, newCol;
        newRow = rowValue;
        newCol = colValue + 1;

        if (maze[newRow][newCol] == fill && maze[newRow - 1][newCol] == fill && maze[newRow - 1][newCol + 1] == fill && maze[newRow][newCol + 1] == fill && maze[newRow + 1][newCol + 1] == fill && maze[newRow + 1][newCol] == fill) {
            return true;
        } else {
            return false;
        }
    }

    private boolean checkSurroundingsDown() {
        int newRow, newCol;
        newRow = rowValue + 1;
        newCol = colValue;

        if (maze[newRow][newCol] == fill && maze[newRow][newCol + 1] == fill && maze[newRow + 1][newCol + 1] == fill && maze[newRow + 1][newCol] == fill && maze[newRow + 1][newCol - 1] == fill && maze[newRow][newCol - 1] == fill) {
            return true;
        } else {
            return false;
        }
    }

    private boolean checkSurroundingsLeft() {
        int newRow, newCol;
        newRow = rowValue;
        newCol = colValue - 1;

        if (maze[newRow][newCol] == fill && maze[newRow - 1][newCol] == fill && maze[newRow + 1][newCol] == fill && maze[newRow + 1][newCol - 1] == fill && maze[newRow][newCol - 1] == fill && maze[newRow - 1][newCol - 1] == fill) {
            return true;
        } else {
            return false;
        }
    }

    private void placePath() {
        maze[rowValue][colValue] = path;
    }

}
