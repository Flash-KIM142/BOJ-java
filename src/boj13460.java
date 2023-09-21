// 2023.09.17 samsung

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj13460 {

    static int N,M;
    static char[][] map;
    static boolean[][][][] visited;
    static int[] target = new int[2];
    static int[] dirR = {1, -1, 0, 0};
    static int[] dirC = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(bfr.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        int[] red = new int[2];
        int[] blue = new int[2];
        map = new char[N][M];
        visited = new boolean[N][M][N][M];
        for(int r=0; r<N; r++){
            String input = bfr.readLine();
            for (int c = 0; c < M; c++) {
                map[r][c] = input.charAt(c);

                if(map[r][c]=='O'){
                    target[0] = r;
                    target[1] = c;
                }
                else if(map[r][c]=='R'){
                    red[0] = r;
                    red[1] = c;
                }
                else if(map[r][c]=='B'){
                    blue[0] = r;
                    blue[1] = c;
                }
            }
        }

        System.out.println(bfs(red[0], red[1], blue[0], blue[1], 0));
    }

    static int bfs(int rr, int rc, int br, int bc, int cnt){

        Queue<int[]> q = new LinkedList<>();
        visited[rr][rc][br][bc] = true;
        q.add(new int[]{rr, rc, br, bc, cnt});

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int curCnt = cur[4];

            if(curCnt>=10)  return -1;

            for(int d=0; d<4; d++){
                int curRr = cur[0];
                int curRc = cur[1];
                int curBr = cur[2];
                int curBc = cur[3];

                while(map[curRr+dirR[d]][curRc+dirC[d]]!='#'){
                    curRr += dirR[d];
                    curRc += dirC[d];
                    if(map[curRr][curRc]=='O')  break;
                }

                while(map[curBr+dirR[d]][curBc+dirC[d]]!='#'){
                    curBr += dirR[d];
                    curBc += dirC[d];
                    if(map[curBr][curBc]=='O')  break;
                }

                if(map[curBr][curBc]=='O')  continue;

                if(map[curRr][curRc]=='O')  return curCnt+1;

                if(curRr==curBr && curRc==curBc){
                    int rMove = Math.abs(curRr - cur[0]) + Math.abs(curRc - cur[1]);
                    int bMove = Math.abs(curBr - cur[2]) + Math.abs(curBc - cur[3]);

                    if(rMove>bMove){
                        curRr -= dirR[d];
                        curRc -= dirC[d];
                    }
                    else{
                        curBr -= dirR[d];
                        curBc -= dirC[d];
                    }
                }

                if(!visited[curRr][curRc][curBr][curBc]){
                    visited[curRr][curRc][curBr][curBc] = true;
                    q.add(new int[]{curRr, curRc, curBr, curBc, curCnt + 1});
                }
            }
        }

        return -1;
    }
}