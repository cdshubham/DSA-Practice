package Recursion;

import java.util.Scanner;

public class FloodFill {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[][] maze=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                maze[i][j]=sc.nextInt();
            }
        }
        boolean[][] visited=new boolean[n][m];
        floodFill(maze,0,0,"",visited);
        sc.close();
    }
    public static void floodFill(int[][] maze, int sr, int sc, String psf, boolean[][] visited) {
        if (sr < 0 || sc < 0 || sr == maze.length || sc == maze[0].length || maze[sr][sc] == 1 || visited[sr][sc]) {
            return;
        }
        if (sr == maze.length - 1 && sc == maze[0].length - 1) {
            System.out.println(psf);
            return;
        }
        visited[sr][sc] = true;
        floodFill(maze, sr - 1, sc, psf + "t", visited); // top
        floodFill(maze, sr, sc - 1, psf + "l", visited); // left
        floodFill(maze, sr + 1, sc, psf + "d", visited); // down
        floodFill(maze, sr, sc + 1, psf + "r", visited); // right
        visited[sr][sc] = false; // backtrack
    }
    
}
