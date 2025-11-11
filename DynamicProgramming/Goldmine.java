package DynamicProgramming;

import java.util.Scanner;

public class Goldmine {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[][] grid=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                grid[i][j]=sc.nextInt();
            }
        }
        System.out.println("Naive Recursion: "+getMaxGoldRecursive(grid,0,0));
        // System.out.println("Memoization: "+getMaxGoldMemo(grid,0,0,new
        //         int[n][m]));
        // System.out.println("Tabulation: "+getMaxGoldTab(grid));
        // System.out.println("Space Optimized: "+getMaxGoldSpaceOptimized(grid));

    }
    //1. Naive Recursion
    public static int getMaxGoldRecursive(int[][] grid,int i,int j){
        int n=grid.length;
        int m=grid[0].length;
        if(i<0 || j<0 || i>=n || j>=m) return 0; //out of bounds
        if(i==n-1 && j==m-1) return grid[i][j]; //reached destination

        int right=getMaxGoldRecursive(grid,i,j+1);
        int down=getMaxGoldRecursive(grid,i+1,j);
        int up=getMaxGoldRecursive(grid,i-1,j);

        return grid[i][j]+Math.max(right,Math.max(down,up));
    }
    //2. Memoization
    public static int getMaxGoldMemo(int[][] grid,int i,int j,int[][] dp){
        int n=grid.length;
        int m=grid[0].length;
        if(i<0 || j<0 || i>=n || j>=m) return 0; //out of bounds
        if(i==n-1 && j==m-1) return grid[i][j]; //reached destination
        if(dp[i][j]!=0) return dp[i][j]; //already computed

        int right=getMaxGoldMemo(grid,i,j+1,dp);
        int down=getMaxGoldMemo(grid,i+1,j,dp);
        int up=getMaxGoldMemo(grid,i-1,j,dp);

        dp[i][j]=grid[i][j]+Math.max(right,Math.max(down,up));
        return dp[i][j];
    }
    //3. Tabulation
    public static int getMaxGoldTab(int[][] grid){
        int n=grid.length;
        int m=grid[0].length;
        int[][] dp=new int[n][m];

        for(int j=m-1;j>=0;j--){
            for(int i=0;i<n;i++){
                if(j==m-1){ //last column
                    dp[i][j]=grid[i][j];
                }else if(i==0){ //first row
                    dp[i][j]=grid[i][j]+Math.max(dp[i][j+1],dp[i+1][j+1]);
                }else if(i==n-1){ //last row
                    dp[i][j]=grid[i][j]+Math.max(dp[i][j+1],dp[i-1][j+1]);
                }else{ //middle cells
                    dp[i][j]=grid[i][j]+Math.max(dp[i][j+1],Math.max(dp[i-1][j+1],dp[i+1][j+1]));
                }
            }
        }
        return dp[0][0];
    }
    //4. Space Optimization
    public static int getMaxGoldSpaceOptimized(int[][] grid){
        int n=grid.length;
        int m=grid[0].length;
        int[] next=new int[n];
        int[] curr=new int[n];

        for(int j=m-1;j>=0;j--){
            for(int i=0;i<n;i++){
                if(j==m-1){ //last column
                    curr[i]=grid[i][j];
                }else if(i==0){ //first row
                    curr[i]=grid[i][j]+Math.max(next[i],next[i+1]);
                }else if(i==n-1){ //last row
                    curr[i]=grid[i][j]+Math.max(next[i],next[i-1]);
                }else{ //middle cells
                    curr[i]=grid[i][j]+Math.max(next[i],Math.max(next[i-1],next[i+1]));
                }
            }
            next=curr.clone();
        }
        return curr[0];
    }
}
