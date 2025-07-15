import java.util.*;

public class second {
    public static int countSpecialIndices(int[] nums) {
        int n = nums.length;

        int[] evenPrefix = new int[n + 1];
        int[] oddPrefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            evenPrefix[i + 1] = evenPrefix[i];
            oddPrefix[i + 1] = oddPrefix[i];
            if (i % 2 == 0) {
                evenPrefix[i + 1] += nums[i];
            } else {
                oddPrefix[i + 1] += nums[i];
            }
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            // After removing index i:
            // Elements after index i shift: even becomes odd, odd becomes even
            int evenSum = evenPrefix[i] + (oddPrefix[n] - oddPrefix[i + 1]);
            int oddSum = oddPrefix[i] + (evenPrefix[n] - evenPrefix[i + 1]);

            if (evenSum == oddSum) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int result = countSpecialIndices(nums);
        System.out.println(result);
    }
}
