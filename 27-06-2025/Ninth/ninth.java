import java.util.*;

public class ninth {
    public static int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int time = 0;
        for (int[] course : courses) {
            time += course[0];
            pq.offer(course[0]);
            if (time > course[1]) {
                time -= pq.poll();
            }
        }
        return pq.size();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] courses = new int[n][2];
        for (int i = 0; i < n; i++) {
            courses[i][0] = sc.nextInt();
            courses[i][1] = sc.nextInt();
        }
        System.out.println(scheduleCourse(courses));
    }
}
