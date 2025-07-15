import java.util.*;

public class third {
    public static String[] findRelativeRanks(int[] score) {
        int n = score.length;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = score[i];
            arr[i][1] = i;
        }
        Arrays.sort(arr, (a, b) -> b[0] - a[0]);
        String[] res = new String[n];
        for (int i = 0; i < n; i++) {
            int idx = arr[i][1];
            if (i == 0) res[idx] = "Gold Medal";
            else if (i == 1) res[idx] = "Silver Medal";
            else if (i == 2) res[idx] = "Bronze Medal";
            else res[idx] = String.valueOf(i + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] scores = {10, 3, 8, 9, 4};
        String[] ranks = findRelativeRanks(scores);
        for (String rank : ranks) {
            System.out.println(rank);
        }
    }
}
