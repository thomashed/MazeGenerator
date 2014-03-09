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
        this.maze = new char[100][100];

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
        resetData();
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
                System.out.print(maze[row][col] + "");
            }
            System.out.println();
        }
    }

    public boolean isPlaceValid(int direction) {

        // Checks up
        if (direction == 1) {
            if ((rowValue - 1) != 0) {
                if (checkSurroundingsUp()) {
                    return true;
                }
            }
        }

        // Checks right
        if (direction == 2) {
            if ((colValue + 1) != 99) {
                if (checkSurroundingsRight()) {
                    return true;
                }
            }
        }

        // Checks down
        if (direction == 3) {
//            if ((rowValue + 1) != 19) {
//                if (checkSurroundingsDown()) {
                    return true;
//                }
//            }
        }

        // Checks left
        if (direction == 4) {
            if ((colValue - 1) != 0) {
                if (checkSurroundingsLeft()) {
                    return true;
                }
            }
        }
        
        // As a defualt it returns false!
        return false;
    }

    private void resetData() {

        for (int row = 0; row < maze.length; row++) {
            for (int col = 0; col < maze[0].length; col++) {
                maze[row][col] = fill;
            }
        }

        rowValue = 0;
        colValue = 0;
    }

    // Path making methods
    private void makePath() {
        Random r = new Random();
        setStartCoordinates();

        while (rowValue != 99) {
            int chooseMovement = r.nextInt(9);

            switch (chooseMovement) {
                case 0:
                    moveUp();
                    break;
                case 1:
                    moveUp();
                    break;
                case 2:
                    moveRight();
                    break;
                case 3:
                    moveRight();
                    break;
                case 4:
                    moveLeft();
                    break;
                case 5:
                    moveLeft();
                    break;
                case 6:
                    moveUp();
                    break;
                case 7:
                    moveUp();
                    break;
                default:
                    moveDown();
                    break;
            }
        }

    }

    private void setStartCoordinates() {
        Random r = new Random();
        colValue = r.nextInt(50)+30;
        placePath();
        moveDown();
    }

    // MoveMethods
    private void moveUp() {
        if (isPlaceValid(1)) {
            rowValue = rowValue - 1;
            placePath();
        }
    }

    private void moveRight() {
        if (isPlaceValid(2)) {
            colValue = colValue + 1;
            placePath();
        }
    }

    private void moveDown() {
        if (isPlaceValid(3)) {
            rowValue = rowValue + 1;
            placePath();
        }
    }

    private void moveLeft() {
        if (isPlaceValid(4)) {
            colValue = colValue - 1;
            placePath();
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
