import java.io.*;
import java.util.*;

public class boj11724 {
    static int N,M;
    static boolean[][] edges;
    static boolean[] visited;

    static void dfs(int idx){
        if(visited[idx])    return;

        visited[idx] = true;
        for(int i=0; i<N; i++){
            if(edges[idx][i]){
                dfs(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(bfr.readLine());
        N = Integer.parseInt(stk.nextToken()); // vertex
        M = Integer.parseInt(stk.nextToken()); // edge

        edges = new boolean[N][N];
        visited = new boolean[N];

        for(int i=0; i<M; i++){ // 간선 정보 입력 받기
            stk = new StringTokenizer(bfr.readLine());
            int u = Integer.parseInt(stk.nextToken());
            int v = Integer.parseInt(stk.nextToken());

            edges[u-1][v-1] = true;
            edges[v-1][u-1] = true;
        }

        int res = 0;
        for(int i=0; i<N; i++){
            if(!visited[i]){
                dfs(i);
                res++;
            }
        }

        System.out.println(res);
    }
}