import java.util.*;

public class ninth {
    public static String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[n] = 0;

        for (int i = n - 1; i >= 0; i--) {
            int take = 0;
            for (int k = 0; k < 3 && i + k < n; k++) {
                take += stoneValue[i + k];
                dp[i] = Math.max(dp[i], take - dp[i + k + 1]);
            }
        }

        if (dp[0] > 0) return "Alice";
        if (dp[0] < 0) return "Bob";
        return "Tie";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] stoneValue = new int[n];
        for (int i = 0; i < n; i++) {
            stoneValue[i] = sc.nextInt();
        }
        System.out.println(stoneGameIII(stoneValue));
    }
}
