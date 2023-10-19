// 2023.10.19 priority queue

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class boj1927 {

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(bfr.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){
                return o1-o2;
            }
        });

        for(int i=0; i<N; i++){
            int cur = Integer.parseInt(bfr.readLine());
            if(cur==0){
                if(pq.isEmpty()){
                    bfw.write("0\n");
                }
                else{
                    bfw.write(pq.poll()+"\n");
                }
            }
            else{
                pq.add(cur);
            }
        }

        bfw.flush();
        bfw.close();
    }
}