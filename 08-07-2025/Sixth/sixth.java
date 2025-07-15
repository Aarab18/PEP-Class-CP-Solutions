import java.util.*;

public class sixth {
    public static boolean checkValidString(String s) {
        int low = 0, high = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                low++;
                high++;
            } else if (c == ')') {
                low = Math.max(0, low - 1);
                high--;
            } else {
                low = Math.max(0, low - 1);
                high++;
            }
            if (high < 0) return false;
        }
        return low == 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(checkValidString(s));
    }
}
