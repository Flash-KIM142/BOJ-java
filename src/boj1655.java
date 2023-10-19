// 2023.10.19 priority queue

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class boj1655 {

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(bfr.readLine());

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        for(int i=0; i<N; i++){
            int n = Integer.parseInt(bfr.readLine());

            if(maxHeap.size()==minHeap.size()){
                maxHeap.add(n);
            }
            else{
                minHeap.add(n);
            }

            if(!maxHeap.isEmpty() && !minHeap.isEmpty()){
                if(maxHeap.peek()>minHeap.peek()){
                    int tmp = maxHeap.poll();
                    maxHeap.add(minHeap.poll());
                    minHeap.add(tmp);
                }
            }

            bfw.write(maxHeap.peek()+"\n");
        }

        bfw.flush();
        bfw.close();
    }
}