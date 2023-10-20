// 2023.10.20 다익스트라

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj1753re {

    static final Integer INF = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bfr.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(bfr.readLine());

        int[] dist = new int[V+1];
        Arrays.fill(dist, INF);
        dist[K] = 0;

        List<Node>[] graph = new List[V+1];
        for(int i=1; i<=V; i++) graph[i] = new ArrayList<>();

        for(int i=0; i<E; i++){
            st = new StringTokenizer(bfr.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Node(v,w));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(K, 0));

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if(cur.weight>dist[cur.end])  continue;

            List<Node> adjEnd = graph[cur.end];
            for(Node adj: adjEnd){
                if(dist[adj.end]>cur.weight + adj.weight){
                    dist[adj.end] = cur.weight + adj.weight;
                    pq.add(new Node(adj.end, dist[adj.end]));
                }
            }
        }

        for(int i=1; i<=V; i++){
            if(dist[i]==INF){
                bfw.write("INF\n");
            }
            else{
                bfw.write(dist[i]+"\n");
            }
        }

        bfw.flush();
        bfw.close();
    }

    static class Node implements Comparable<Node> {
        int end;
        int weight;

        Node(int end, int weight){
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node other){
            return weight - other.weight;
        }
    }
}