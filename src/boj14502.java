import java.io.*;
import java.util.*;

public class boj14502 {
    static int N,M;
    static int[][] map;
    static int max = 0;
    static int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N][M];
        for(int i=0; i<N; i++)
            for(int j=0; j<M; j++)
                map[i][j] = sc.nextInt();

//        dfs(0);
        backtracking(0, 0, 0);
        System.out.println(max);
    }

//    static void dfs(int cnt){
//        if(cnt==3){
//            int[][] tmp = new int[N][M];
//            for(int i=0; i<N; i++)
//                tmp[i] = map[i].clone();
//
//            bfs(tmp);
//            return;
//        }
//
//        for(int i=0; i<N; i++){
//            for(int j=0; j<M; j++){
//                if(map[i][j]==0){
//                    map[i][j] = 1;
//                    dfs(cnt+1);
//                    map[i][j] = 0;
//                }
//            }
//        }
//    }

    static void backtracking(int cnt, int r, int c){
        if(cnt==3){
            int[][] tmp = new int[N][M];
            for(int i=0; i<N; i++)
                tmp[i] = map[i].clone();

            bfs(tmp);
            return;
        }

        for(int i=r; i<N; i++){
            for(int j=c; j<M; j++){
                if(map[i][j]==0){
                    map[i][j] = 1;
                    if(c==M-1)  backtracking(cnt+1, i+1, 0);
                    else    backtracking(cnt+1, i, j+1);
                    map[i][j] = 0;
                }
            }
        }
    }

    static void bfs(int[][] newMap){
        Queue<Pos> q = new LinkedList<>();
        for(int i=0; i<N; i++)
            for(int j=0; j<M; j++)
                if(newMap[i][j]==2)
                    q.add(new Pos(i,j));

        while(!q.isEmpty()){
            Pos cur = q.poll();

            for(int d=0; d<4; d++){
                int nR = cur.r + dir[d][0];
                int nC = cur.c + dir[d][1];

                if(isInRange(nR,nC) && (newMap[nR][nC]==0)){
                    newMap[nR][nC] = 2;
                    q.add(new Pos(nR,nC));
                }
            }
        }

        int cnt = 0;
        for(int[] row: newMap)
            for(int e: row)
                if(e==0)    cnt++;

        max = Math.max(cnt, max);
    }

    static boolean isInRange(int r, int c){ return r>=0 && r<N && c>=0 && c<M;  }

    static class Pos{
        int r,c;

        Pos(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
}
