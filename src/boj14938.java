// 2023.10.18 floyd

import java.util.Scanner;

public class boj14938 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int r = sc.nextInt();
        int[] items = new int[n];
        for (int i = 0; i < n; i++) items[i] = sc.nextInt();

        int[][] dist = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i==j)    dist[i][j] = 0;
                else    dist[i][j] = 1000000000;
            }
        }

        for(int i=0; i<r; i++){
            int s = sc.nextInt()-1;
            int e = sc.nextInt()-1;
            int d = sc.nextInt();
            dist[s][e] = d;
            dist[e][s] = d;
        }

        for(int k=0; k<n; k++){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(i==j)    continue;

                    if(dist[i][j]>dist[i][k]+dist[k][j])    dist[i][j] = dist[i][k]+dist[k][j];
                }
            }
        }

        /* 모든 node를 기점으로 m 이내의 node 방문했을 때 얻을 수 있는 item 개수 계산하기 */
        int max = -1;
        for(int i=0; i<n; i++){
            int total = 0;
            for(int j=0; j<n; j++){
                if(dist[i][j]<=m){
                    total += items[j];
                }
            }
            if(max<total)   max = total;
        }

        System.out.println(max);
    }
}