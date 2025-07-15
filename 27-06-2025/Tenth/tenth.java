import java.util.*;

public class tenth {
    public static double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        double[][] workers = new double[n][2];
        for (int i = 0; i < n; i++) {
            workers[i][0] = (double) wage[i] / quality[i];
            workers[i][1] = quality[i];
        }
        Arrays.sort(workers, Comparator.comparingDouble(a -> a[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int sumq = 0;
        double res = Double.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int q = (int) workers[i][1];
            pq.offer(q);
            sumq += q;
            if (pq.size() > k) sumq -= pq.poll();
            if (pq.size() == k) res = Math.min(res, sumq * workers[i][0]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] quality = {10, 20, 5};
        int[] wage = {70, 50, 30};
        int k = 2;
        double result = mincostToHireWorkers(quality, wage, k);
        System.out.printf("%.5f\n", result);
    }
}
