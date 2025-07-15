import java.util.*;

public class third {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        if (obstacleGrid[0][0] == 1) return 0;
        dp[0][0] = 1;

        for (int i = 1; i < m; i++)
            dp[i][0] = obstacleGrid[i][0] == 0 ? dp[i - 1][0] : 0;

        for (int j = 1; j < n; j++)
            dp[0][j] = obstacleGrid[0][j] == 0 ? dp[0][j - 1] : 0;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0)
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] obstacleGrid = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                obstacleGrid[i][j] = sc.nextInt();

        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }
}
