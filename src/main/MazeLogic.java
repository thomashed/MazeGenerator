package main;

import java.util.Random;

public class MazeLogic {

    // Fields
    Random r;

    char[][] maze;

    // Constructor
    public MazeLogic() {
        this.maze = new char[10][10];
    }

    // Methods
    public void run() {
        fillMaze();
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

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
