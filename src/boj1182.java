// 백트래킹. 2023.07.12

import java.util.Scanner;

public class boj1182 {

    static int N, S, cnt;
    static int[] ary;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = sc.nextInt();

        ary = new int[N];
        for(int i=0; i<N; i++) {
            ary[i] = sc.nextInt();
        }

        backtracking(0, 0);
        if(S==0)    cnt--;
        System.out.println(cnt);
    }

    static void backtracking(int cur, int sum){
        if(cur==N){
            if(sum==S)  cnt++;
            return;
        }

        backtracking(cur+1, sum);
        backtracking(cur+1, sum + ary[cur]);
    }
}