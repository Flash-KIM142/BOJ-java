// 2023.10.20 다익스트라

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj11779 {

    static final Integer MAX = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bfr.readLine());
        int M = Integer.parseInt(bfr.readLine());

        List<Node>[] edges = new List[N+1];
        for(int i=1; i<=N; i++) edges[i] = new ArrayList<>();

        StringTokenizer st;
        for(int i=0; i<M; i++){
            st = new StringTokenizer(bfr.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            edges[u].add(new Node(v,w));
        }

        st = new StringTokenizer(bfr.readLine());
        int src = Integer.parseInt(st.nextToken());
        int dst = Integer.parseInt(st.nextToken());

        int[] dist = new int[N+1];
        Arrays.fill(dist, MAX);
        dist[src] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(src, 0));
        int[] before = new int[N+1];

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if(dist[cur.end]!=cur.weight)   continue;

            List<Node> adjNodes = edges[cur.end];
            for(Node adj: adjNodes){
                if(dist[adj.end]>cur.weight + adj.weight){
                    dist[adj.end] = cur.weight + adj.weight;
                    before[adj.end] = cur.end;
                    pq.add(new Node(adj.end, dist[adj.end]));
                }
            }
        }

        System.out.println(dist[dst]);
        int idx = dst;
        Stack<Integer> stk = new Stack<>();
        while(idx!=0){
            stk.add(idx);
            idx = before[idx];
        }
        System.out.println(stk.size());
        while(!stk.isEmpty()){
            System.out.print(stk.pop() + " ");
        }
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