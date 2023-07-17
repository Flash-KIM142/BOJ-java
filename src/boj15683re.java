// simulation. 2023.07.13

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class boj15683re {

    static int N, M;
    static int[][] map;
    static int ans = 999999999;

    static int[][][] camDir = {{{0}}, {{0}, {1}, {2}, {3},},  // cam1
            {{0, 1}, {2, 3}}, // cam2
            {{0, 3}, {1, 3}, {1, 2}, {0, 2}}, // cam3
            {{0, 2, 3}, {0, 1, 3}, {1, 2, 3}, {0, 1, 2}}, // cam4
            {{0, 1, 2, 3}}}; // cam5

    static int[][] dir = { {-1,0}, {1,0}, {0,-1}, {0,1} }; // 상 하 좌 우

    static List<CCTV> cctvs = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N][M];
        for(int r=0; r<N; r++)
            for(int c=0; c<M; c++) {
                map[r][c] = sc.nextInt();
                if(map[r][c]>=1 && map[r][c]<=5){
                    cctvs.add(new CCTV(r,c,map[r][c]));
                }
            }

        combination(0, cctvs.size(), map);
        System.out.println(ans);
    }

    static void combination(int depth, int total, int[][] curMap){
        if(depth==total){
            int cnt = countBlindSpot(curMap);
            ans = Math.min(ans, cnt);
            return;
        }

        int type = cctvs.get(depth).type;
        int cur_r = cctvs.get(depth).r;
        int cur_c = cctvs.get(depth).c;

        for(int i=0; i<camDir[type].length; i++){
            int[][] copy_map = new int[N][M];
            for(int r=0; r<N; r++)
                copy_map[r] = curMap[r].clone();

            for(int j=0; j<camDir[type][i].length; j++){
                int cur_dir = camDir[type][i][j];
                int nxt_r = cur_r + dir[cur_dir][0];
                int nxt_c = cur_c + dir[cur_dir][1];

                while(true){
                    if(isOutOfRange(nxt_r,nxt_c))   break;
                    if(map[nxt_r][nxt_c]==6)    break;

                    copy_map[nxt_r][nxt_c] = -1;
                    nxt_r += dir[cur_dir][0];
                    nxt_c += dir[cur_dir][1];
                }
            }

            combination(depth+1, total, copy_map);
        }
    }

    static int countBlindSpot(int[][] map){
        int cnt = 0;
        for(int r=0; r<N; r++){
            for(int c=0; c<M; c++){
                if(map[r][c]==0)
                    cnt++;
            }
        }

        return cnt;
    }

    static boolean isOutOfRange(int r, int c){
        return r<0 || r>=N || c<0 || c>=M;
    }

    static class CCTV {
        int r, c;
        int type;

        CCTV(int r, int c, int type){
            this.r = r;
            this.c = c;
            this.type = type;
        }
    }
}