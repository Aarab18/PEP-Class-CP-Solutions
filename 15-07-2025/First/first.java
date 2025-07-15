import java.util.*;
class first {
    
    static int[][] connectionGraph;
    static boolean[] visited;

    public static  int findCircleNum(int[][] isConnected) {
        connectionGraph = isConnected;
        int numCities = connectionGraph.length;
        visited = new boolean[numCities];
        int numProvinces = 0;
        for (int i = 0; i < numCities; ++i) {
            if (!visited[i]) {
                dfs(i);
                ++numProvinces;
            }
        }
        return numProvinces;
    }

    private static void dfs(int cityIndex) {
        visited[cityIndex] = true;
        for (int destination = 0; destination < connectionGraph.length; ++destination) {
            if (!visited[destination] && connectionGraph[cityIndex][destination] == 1) {
                dfs(destination);
            }
        }
    }
    
    public static void main(String args[]) {
        Scanner ob=new Scanner(System.in);
        int arr[][]=new int[3][3];
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                arr[i][j]=ob.nextInt();
            }
        }
        int ans=findCircleNum(arr);
        System.out.println(ans);
    }
}
