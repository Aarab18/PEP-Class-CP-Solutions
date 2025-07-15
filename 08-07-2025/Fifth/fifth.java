import java.util.*;

public class fifth {
    public static int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (int[] row : dp) Arrays.fill(row, Integer.MAX_VALUE);
        dp[m][n - 1] = 1;
        dp[m - 1][n] = 1;

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int need = Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j];
                dp[i][j] = Math.max(1, need);
            }
        }

        return dp[0][0];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        int[][] dungeon = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                dungeon[i][j] = sc.nextInt();
        System.out.println(calculateMinimumHP(dungeon));
    }
}
