// 2023.10.19 priority queue

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj13975 {

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(bfr.readLine());

        PriorityQueue<Long> pq = new PriorityQueue<>(new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                return (int) (o1 - o2); // You need to cast the result to int
            }
        });

        for(int i=0; i<T; i++){
            int N = Integer.parseInt(bfr.readLine());
            StringTokenizer st = new StringTokenizer(bfr.readLine());
            while(st.hasMoreTokens())   pq.add(Long.parseLong(st.nextToken()));

            Long result = 0L;
            while(pq.size()!=1){
                Long a = pq.poll();
                Long b = pq.poll();

                result += a + b;
                pq.add(a+b);
            }

            bfw.write(result + "\n");
            pq.clear();
        }

        bfw.flush();
        bfw.close();
    }
}