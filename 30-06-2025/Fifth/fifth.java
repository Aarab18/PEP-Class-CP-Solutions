import java.util.*;

public class fifth {
    public static int[] secondGreaterElement(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Deque<Integer> firstStack = new ArrayDeque<>();
        Deque<Integer> secondStack = new ArrayDeque<>();
        List<Integer> buffer = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            while (!secondStack.isEmpty() && nums[secondStack.peek()] < nums[i]) {
                res[secondStack.pop()] = nums[i];
            }

            buffer.clear();
            while (!firstStack.isEmpty() && nums[firstStack.peek()] < nums[i]) {
                buffer.add(firstStack.pop());
            }
            for (int j = buffer.size() - 1; j >= 0; j--) {
                secondStack.push(buffer.get(j));
            }

            firstStack.push(i);
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int[] result = secondGreaterElement(nums);
        for (int val : result) {
            System.out.print(val + " ");
        }
    }
}
