// 백트래킹. 2023.07.12

import java.util.Scanner;

public class boj9663 {

    static int N;
    static int[][] map;
    static boolean[] visited1;
    static boolean[] visited2;
    static boolean[] visited3;
    static int cnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        map = new int[N][N];
        visited1 = new boolean[N];
        visited2 = new boolean[2*N - 1];
        visited3 = new boolean[2*N - 1];
        backtracking(0);
        System.out.println(cnt);
    }

    static void backtracking(int k){
        if(k==N){
            cnt++;
            return;
        }

        for(int c=0; c<N; c++){
            if(visited1[c] || visited2[k+c] || visited3[k-c+N-1])   continue;

            visited1[c] = true;
            visited2[k+c] = true;
            visited3[k-c+N-1] = true;
            backtracking(k+1);
            visited1[c] = false;
            visited2[k+c] = false;
            visited3[k-c+N-1] = false;
        }
    }
}