import java.io.*;
import java.util.*;

public class boj1260{
    static boolean[] visited;
    static ArrayList[] info;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int V = sc.nextInt();

        visited = new boolean[N+1];
        info = new ArrayList[N+1];
        for(int i=0; i<=N; i++) {
            info[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<M; i++){
            int s = sc.nextInt();
            int e = sc.nextInt();

            info[s].add(e);
            info[e].add(s);
        }

        for(int i=1; i<=N; i++)    Collections.sort(info[i]);

        dfs(V);
        System.out.println();
        visited = new boolean[N+1];
        bfs(V);
    }

    static void dfs(int next){
        visited[next] = true;
        System.out.print(next + " ");

        for(Object i: info[next]){
            if(!visited[(int)i]){
                dfs((int)i);
            }
        }
    }

    static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        while(!q.isEmpty()){
            int cur = q.poll();
            System.out.print(cur+" ");

            for(Object i: info[cur]){
                if(!visited[(int)i]) {
                    q.add((int) i);
                    visited[(int) i] = true;
                }
            }
        }
    }
}