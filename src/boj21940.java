// 2023.10.19 floyd

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class boj21940 {

    static final int MAX = 1000000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] dist = new int[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(i==j)    dist[i][j] = 0;
                else    dist[i][j] = MAX;
            }
        }

        for(int i=0; i<M; i++){
            int s = sc.nextInt()-1;
            int e = sc.nextInt()-1;
            int time = sc.nextInt();
            dist[s][e] = time;
        }

        int K = sc.nextInt();
        int[] houses = new int[K];
        for(int i=0; i<K; i++)
            houses[i] = sc.nextInt()-1;

        /* 각 지점으로부터 다른 지점들까지의 최소 거리 구하기 */
        for(int k=0; k<N; k++){
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(i==j)    continue;
                    
                    if(dist[i][j]>dist[i][k]+dist[k][j])   dist[i][j] = dist[i][k]+dist[k][j];
                }
            }
        }

        /* 각 지점별로 K명의 친구들이 걸리는 왕복시간의 최댓값 구해주기 */
        int[] max = new int[N];
        for(int i=0; i<N; i++){
            for(int j=0; j<K; j++){
                int src = houses[j];
                int dst = i;

                if(src==dst)    continue;
                if(dist[src][dst]==MAX || dist[dst][src]==MAX){
                    max[dst] = MAX;
                    break;
                }

                if(max[dst]<dist[src][dst]+dist[dst][src])
                    max[dst] = dist[src][dst]+dist[dst][src];
            }
        }

        /* 최댓값들 중 최소인 지점들 찾아내기 */
        int minOfMax = MAX;
        for(int i: max){
            if(i<minOfMax)   minOfMax = i;
        }

        List<Integer> list = new ArrayList<>();
        for(int i=0; i<N; i++){
            if(max[i]==minOfMax)    list.add(i+1);
        }
        Collections.sort(list);

        for(Integer i: list) System.out.print(i + " ");
    }
}