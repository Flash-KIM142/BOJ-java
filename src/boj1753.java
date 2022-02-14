import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj1753 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(bfr.readLine());
        int V = Integer.parseInt(stk.nextToken()); // 정점 개수
        int E = Integer.parseInt(stk.nextToken()); // 간선 개수
        int K = Integer.parseInt(bfr.readLine());

        /** 간선 가중치 입력 받기 */
        ArrayList<Node>[] edges = new ArrayList[V+1];
        for (int i = 0; i <= V; i++) edges[i] = new ArrayList<>();
        int a, b, cost;
        for (int i = 0; i < E; i++) { // 간선 가중치 정보 입력 받기
            stk = new StringTokenizer(bfr.readLine());
            a = Integer.parseInt(stk.nextToken());
            b = Integer.parseInt(stk.nextToken());
            cost = Integer.parseInt(stk.nextToken());
            edges[a].add(new Node(b, cost));
        }

        /** 각 노드 방문 여부 체크해줄 배열 초기화 */
//        boolean[] visited = new boolean[V + 1]; // 방문 여부 체크해줄 boolean 배열

        /** 다익스트라 알고리즘 적용 ( visited 배열 이용 ) */
//        for (int i = 0; i < V; i++) {
//            int curIdx = 0;
//            int valueOfCurIdx = Integer.MAX_VALUE;
//
//            for (int j = 1; j <= V; j++) {
//                if (!visited[j] && distance[j] < valueOfCurIdx) {
//                    curIdx = j;
//                    valueOfCurIdx = distance[j];
//                }
//            }
//            visited[curIdx] = true;
//
//            for (int j = 0; j < list.get(curIdx).size(); j++) {
//                Node adjNode = list.get(curIdx).get(j);
//                if (distance[adjNode.end] > valueOfCurIdx + adjNode.cost) {
//                    distance[adjNode.end] = valueOfCurIdx + adjNode.cost;
//                }
//            }
//        }

        /** 최소 비용 거리 정보를 담아줄 배열 초기화 */
        int[] distance = new int[V + 1]; // 출발점으로부터 모든 노드까지의 최소 거리를 저장해줄 int 배열
        for (int i = 0; i < V + 1; i++) distance[i] = Integer.MAX_VALUE;
        distance[K] = 0;

        /** 다익스트라 알고리즘 적용 ( 우선순위 큐 이용 ) */
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.offer(new Node(K, 0));

        while(!q.isEmpty()){
            Node cur = q.poll();
            if(distance[cur.end] < cur.cost)    continue;

            for(int i=0; i<edges[cur.end].size(); i++){
                Node next = edges[cur.end].get(i);
                if(distance[next.end] > cur.cost + next.cost) {
                    distance[next.end] = cur.cost + next.cost;
                    q.offer(new Node(next.end, distance[next.end]));
                }
            }
        }

        /** 정답 출력 */
        for (int i = 1; i < V + 1; i++) {
            if (distance[i] == Integer.MAX_VALUE)
                bfw.write("INF\n");
            else
                bfw.write(distance[i] + "\n");
        }
        bfw.close();
    }

    static class Node implements Comparable<Node> {
        int end;
        int cost;

        Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node next){
            return this.cost - next.cost;
        }
    }
}