import java.util.*;

public class sixth {
    public static int calculate(String s) {
        int n = s.length(), sign = 1, result = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                int num = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                i--;
                result += sign * num;
            } else if (ch == '+') {
                sign = 1;
            } else if (ch == '-') {
                sign = -1;
            } else if (ch == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (ch == ')') {
                result = stack.pop() * result + stack.pop();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String expression = sc.nextLine();
        int result = calculate(expression);
        System.out.println(result);
    }
}
