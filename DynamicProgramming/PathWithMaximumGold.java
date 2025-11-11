package DynamicProgramming;

public class PathWithMaximumGold {
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
        System.out.println("Memoization: "+getMaxGoldMemo(grid,0,0,new
                int[n][m]));
        System.out.println("Tabulation: "+getMaxGoldTab(grid));
        System.out.println("Space Optimized: "+getMaxGoldSpaceOptimized(grid));

    }
    //1. Naive Recursion
    public static int getMaxGoldRecursive(int[][] grid,int i,int j){
        int n=grid.length;
        int m=grid[0].length;
        if(i>=n || j>=m) return 0; //out of bounds
        if(i==n-1 && j==m-1) return grid[i][j]; //reached destination

        int right=getMaxGoldRecursive(grid,i,j+1);
        int down=getMaxGoldRecursive(grid,i+1,j);

        return grid[i][j]+Math.max(right,down);
    }
    //2. Recursion + Memoization (Top-Down DP)
    public static int getMaxGoldMemo(int[][] grid,int i,int j,int[][] dp){
        int n=grid.length;
        int m=grid[0].length;
        if(i>=n || j>=m) return 0;
        if(i==n-1 && j==m-1) return grid[i][j];
        if(dp[i][j]!=0) return dp[i][j];

        int right=getMaxGoldMemo(grid,i,j+1,dp);
        int down=getMaxGoldMemo(grid,i+1,j,dp);

        dp[i][j]=grid[i][j]+Math.max(right,down);
        return dp[i][j];
    }
    //3. Tabulation (Bottom-Up DP)
    public static int getMaxGoldTab(int[][] grid){
        int n=grid.length;
        int m=grid[0].length;
        int[][] dp=new int[n][m];

        dp[0][0]=grid[0][0];

        //first row
        for(int j=1;j<m;j++){
            dp[0][j]=grid[0][j]+dp[0][j-1];
        }

        //first column
        for(int i=1;i<n;i++){
            dp[i][0]=grid[i][0]+dp[i-1][0];
        }

        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                dp[i][j]=grid[i][j]+Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[n-1][m-1];
    }
    //4. Space Optimized
    public static int getMaxGoldSpaceOptimized(int[][] grid){
        int n=grid.length;
        int m=grid[0].length;
        int[] prev=new int[m];

        for(int i=0;i<n;i++){
            int[] curr=new int[m];
            for(int j=0;j<m;j++){
                if(i==0 && j==0){
                    curr[j]=grid[i][j];
                }
                else{
                    int up=grid[i][j];
                    if(i>0) up+=prev[j];
                    int left=grid[i][j];
                    if(j>0) left+=curr[j-1];
                    curr[j]=Math.max(up,left);
                }
            }
            prev=curr;
        }
        return prev[m-1];
    }
    
}
