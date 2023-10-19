// 2023.10.19 priority queue

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj2075 {

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bfr.readLine());

        int[][] map = new int[N][N];
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){
                return o2-o1;
            }
        });

        StringTokenizer st;
        for(int i=0; i<N; i++){
            int j = 0;
            st = new StringTokenizer(bfr.readLine());

            while(st.hasMoreTokens()) {
                map[i][j] = Integer.parseInt(st.nextToken());
                pq.add(map[i][j]);
                j++;
            }
        }

        int result = 0;
        for(int i=0; i<N; i++)  result = pq.poll();

        System.out.println(result);
    }
}