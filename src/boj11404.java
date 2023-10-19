// 2023.10.18 floyd

import java.util.Scanner;

public class boj11404 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] cost = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i==j)    cost[i][j] = 0;
                else    cost[i][j] = 1000000000;
            }
        }

        for(int i=0; i<m; i++){
            int s = sc.nextInt()-1;
            int e = sc.nextInt()-1;
            int c = sc.nextInt();

            if(cost[s][e]>c)    cost[s][e] = c;
        }

        for(int k=0; k<n; k++){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(i==j)    continue;

                    if(cost[i][j]>cost[i][k]+cost[k][j])    cost[i][j] = cost[i][k]+cost[k][j];
                }
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(cost[i][j]==1000000000) System.out.print("0 ");
                else System.out.print(cost[i][j] + " ");
            }
            System.out.println();
        }
    }
}