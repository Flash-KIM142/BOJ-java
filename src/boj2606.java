import java.util.*;
import java.io.*;

public class boj2606 {
    static int N,M,count;
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;

    static void dfs(int start){
        visited[start] = true;
        count += 1;
        int size = graph.get(start).size();

        for(int i=0; i<size; i++){
            int vertex = graph.get(start).get(i);
            if(visited[vertex])
                continue;
            dfs(vertex);
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        N = Integer.parseInt(bfr.readLine());
        M = Integer.parseInt(bfr.readLine());
        graph = new ArrayList<ArrayList<Integer>>();
        visited = new boolean[N+1];

        for(int i=0; i<N+1; i++)
            graph.add(new ArrayList<Integer>());

        for(int i=0; i<M; i++){
            stk = new StringTokenizer(bfr.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        dfs(1);
        bfw.write(String.valueOf(count-1));
        bfw.close();
    }
}