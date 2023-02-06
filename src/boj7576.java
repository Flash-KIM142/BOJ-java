import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj7576 {

    static int totalTomato = 0;
    static int ripeTomato = 0;
    static int cnt = 0;
    static int N,M;
    static int[][] map;
    static Queue<int[]> q = new LinkedList<>();
    static boolean[][] visited;
    static int[][] dir = { {-1,0}, {1,0}, {0,-1}, {0,1} }; // 0상 1하 2좌 3우

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt(); // col
        N = sc.nextInt(); // row
        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                map[i][j] = sc.nextInt();
                if(map[i][j]!=-1)   totalTomato++;
                if(map[i][j]==1) {
                    q.add(new int[]{i, j});
                }
            }
        }

        bfs();

        for(int i=0; i<N; i++)
            for(int j=0; j<M; j++)
                if(map[i][j]==1)    ripeTomato++;

        if(totalTomato==ripeTomato){
            System.out.println(cnt-1);
        }
        else System.out.println(-1);
    }

    static void bfs(){

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int[] cur = q.poll();
                visited[cur[0]][cur[1]] = true;

                for(int d=0; d<4; d++){
                    int nR = cur[0] + dir[d][0];
                    int nC = cur[1] + dir[d][1];

                    if(!isInRange(nR,nC))   continue;
                    if(visited[nR][nC]) continue;
                    if(map[nR][nC]!=0) continue;

                    map[nR][nC] = 1;
                    q.add(new int[]{nR, nC});
                }
            }
            cnt++;
        }
    }

    static boolean isInRange(int r, int c){
        return r >= 0 && r < N && c >= 0 && c < M;
    }
}