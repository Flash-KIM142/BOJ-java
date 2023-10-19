// 2023.10.19 priority queue

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class boj1715 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });

        for(int i=0; i<N; i++){
            pq.add(sc.nextInt());
        }

        int result = 0;
        while(pq.size()!=1){
            int a = pq.poll();
            int b = pq.poll();

            result += a+b;
            pq.add(a+b);
        }

        System.out.println(result);
    }
}