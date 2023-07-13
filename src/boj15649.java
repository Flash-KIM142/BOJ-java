// 백트래킹

import java.util.Scanner;

public class boj15649 {

    static int N,M;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N+1];
        visited = new boolean[N+1];

        backtracking(0);
    }

    static void backtracking(int k) {
        if(k==M){
            for(int i=0; i<M; i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i=1; i<=N; i++){
            if(!visited[i]){
                arr[k] = i;
                visited[i] = true;
                backtracking(k+1);
                visited[i] = false;
            }
        }
    }
}