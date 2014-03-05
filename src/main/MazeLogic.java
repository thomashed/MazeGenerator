package main;

import java.util.Random;

public class MazeLogic {

    // Fields
    Random r;

    char[][] maze;
    char path;

    int rowValue;
    int colValue;

    // Constructor
    public MazeLogic() {
        this.maze = new char[20][20];

        this.path = '0';
        this.rowValue = 4;
        this.colValue = 4;
    }

    // Methods
    public void run() {
        fillMaze();
        
        for (int i = 0; i < 5; i++) {
            moveLeft();
        }
        
        
        printMaze();
    }

    private void fillMaze() {
        for (int row = 0; row < maze.length; row++) {
            for (int col = 0; col < maze[0].length; col++) {
                maze[row][col] = '-';
            }
        }
    }

    public void printMaze() {

        for (int row = 0; row < maze.length; row++) {
            for (int col = 0; col < maze[0].length; col++) {
                System.out.print(maze[row][col] + "  ");
            }
            System.out.println("\n");
        }
    }

    private boolean isPlaceValid() {
        if ((rowValue - 1) == 0 || (colValue - 1) == 0 || (colValue + 1) == 19) {
            return false;
        }
        return true;
    }

    // MoveMethods
    private void moveUp() {
        if (isPlaceValid()) {
            rowValue = rowValue - 1;
            placePath();
        }
    }

    private void moveRight() {
        if (isPlaceValid()) {
            colValue = colValue + 1;
            placePath();
        }
    }

    private void moveDown() {
        if (isPlaceValid()) {
            rowValue = rowValue + 1;
            placePath();
        }
    }

    private void moveLeft() {
        if (isPlaceValid()) {
            colValue = colValue - 1;
            placePath();
        }
    }

    private void placePath() {
        maze[rowValue][colValue] = path;
    }

}
