import java.util.*;

public class first {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        double[] result = medianSlidingWindow(nums, k);
        for (double d : result) {
            System.out.print(d + " ");
        }
    }

    public static double[] medianSlidingWindow(int[] nums, int k) {
        PriorityQueue<Long> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        double[] res = new double[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {
            maxHeap.add((long) nums[i]);
            minHeap.add(maxHeap.poll());
            if (maxHeap.size() < minHeap.size()) {
                maxHeap.add(minHeap.poll());
            }
            if (i >= k - 1) {
                if (k % 2 == 0) {
                    res[i - k + 1] = ((double) maxHeap.peek() + (double) minHeap.peek()) / 2.0;
                } else {
                    res[i - k + 1] = (double) maxHeap.peek();
                }
                long toRemove = nums[i - k + 1];
                if (toRemove <= maxHeap.peek()) {
                    maxHeap.remove(toRemove);
                } else {
                    minHeap.remove(toRemove);
                }
                while (maxHeap.size() < minHeap.size()) {
                    maxHeap.add(minHeap.poll());
                }
                while (maxHeap.size() > minHeap.size() + 1) {
                    minHeap.add(maxHeap.poll());
                }
            }
        }
        return res;
    }
}
