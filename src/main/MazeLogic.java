package main;
import java.util.Random;

public class MazeLogic {

    // Fields
    Random r;
    
    char[][] maze;
    
    // Constructor
    public MazeLogic(){
        this.maze = new char[10][10];
    }
    
    // Methods
    public void run(){
        
    }
    
    private void fillMaze(){
        for (int row = 0; row < maze.length; row++) {
            for (int col = 0; col < maze[0].length; col++) {
                maze[row][col] = '-';
            }
        }
    }
    
    
    
    
    
    
    
    
}
