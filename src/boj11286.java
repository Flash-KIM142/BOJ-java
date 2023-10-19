// 2023.10.19 Priority Queue

import java.util.PriorityQueue;
import java.util.Scanner;

public class boj11286 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<Num> pq = new PriorityQueue<>();

        for(int i=0; i<N; i++){
            int cur = sc.nextInt();
            if(cur!=0){
                pq.offer(new Num(cur));
            }
            else{
                if(!pq.isEmpty()){
                    System.out.println(pq.poll().num);
                }
                else{
                    System.out.println("0");
                }
            }
        }


    }

    static class Num implements Comparable<Num> {
        int num;

        Num(int num){
            this.num = num;
        }

        @Override
        public int compareTo(Num other) {
            int thisAb = Math.abs(num);
            int otherAb = Math.abs(other.num);

            if(thisAb<otherAb)  return -1;
            else if(thisAb>otherAb) return 1;
            else {
                return this.num - other.num;
            }
        }
    }
}