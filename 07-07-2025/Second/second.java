import java.util.*;

public class second {
    public static int atMostNGivenDigitSet(String[] digits, int n) {
        String num = String.valueOf(n);
        int numLen = num.length();
        int dLen = digits.length;
        int res = 0;

        for (int i = 1; i < numLen; i++) {
            res += Math.pow(dLen, i);
        }

        for (int i = 0; i < numLen; i++) {
            boolean hasSameNum = false;
            for (String digit : digits) {
                if (digit.charAt(0) < num.charAt(i)) {
                    res += Math.pow(dLen, numLen - i - 1);
                } else if (digit.charAt(0) == num.charAt(i)) {
                    hasSameNum = true;
                }
            }
            if (!hasSameNum) return res;
        }
        return res + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int d = sc.nextInt();
        String[] digits = new String[d];
        for (int i = 0; i < d; i++) {
            digits[i] = sc.next();
        }
        int n = sc.nextInt();
        System.out.println(atMostNGivenDigitSet(digits, n));
    }
}
