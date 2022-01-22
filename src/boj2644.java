import java.util.*;
import java.io.*;

public class boj2644 {
    static int n,m, p1,p2;
    static int[][] map;
    static boolean[] visited;

    public static void main(String args[]) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(bfr.readLine());
        n = Integer.parseInt(stk.nextToken());
        map = new int[n+1][n+1];    visited = new boolean[n+1];
        stk = new StringTokenizer(bfr.readLine());
        p1 = Integer.parseInt(stk.nextToken()); p2 = Integer.parseInt(stk.nextToken());
        stk = new StringTokenizer(bfr.readLine());
        m = Integer.parseInt(stk.nextToken());
        for(int i=0; i<m; i++){
            stk = new StringTokenizer(bfr.readLine());
            int parent = Integer.parseInt(stk.nextToken());
            int child = Integer.parseInt(stk.nextToken());
            map[parent][child] = 1;
            map[child][parent] = 1;
        }

        bfw.write(String.valueOf(bfs(p1,p2)));
        bfw.close();
    }

    static Integer bfs(int p1, int p2){
        int result = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(p1);

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int cur = q.poll();
                visited[cur] = true;
                if(cur==p2) return result;
                for (int child = 1; child <= n; child++) {
                    if (map[cur][child] == 1) {
                        if (!visited[child])
                            q.add(child);
                    }
                }
            }
            result++;
        }
        return -1;
    }
}