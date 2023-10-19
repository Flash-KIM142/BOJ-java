// 2023.10.19 priority queue

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class boj11279 {

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(bfr.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
           @Override
           public int compare(Integer o1, Integer o2){
               return o2 - o1;
           }
        });

        for(int i=0; i<N; i++){
            int n = Integer.parseInt(bfr.readLine());
            if(n==0){
                if(pq.isEmpty()){
                    bfw.write("0\n");
                }
                else{
                    bfw.write(pq.poll() + "\n");
                }
            }
            else{
                pq.add(n);
            }
        }

        bfw.flush();
        bfw.close();
    }
}