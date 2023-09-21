// greedy. 2023.08.28

import java.util.Scanner;

public class boj11047 {

    static int N,K;
    static int[] ary;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        ary = new int[N+1];

        int top = 0;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            ary[i] = sc.nextInt();
            if(K/ary[i] >0) top = i;
        }

        while(true){
            if(K==0)    break;

            int cur = ary[top];
            cnt += K/cur;

            K %= cur;
            top--;
        }

        System.out.println(cnt);
    }
}