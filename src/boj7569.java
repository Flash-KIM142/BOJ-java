import java.util.Queue;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.io.*;

public class boj7569 {
    static int m, n, h;
    static int[][][] map;
    static boolean[][][] visited;
    static Queue<Pos> alreadyRipe = new LinkedList<>();
    static int[][] move = {{-1, 0, 0}, {1, 0, 0}, {0, -1, 0}, {0, 1, 0}, {0, 0, -1}, {0, 0, 1}}; // 위 아래 앞 뒤 좌 우

    public static void main(String args[]) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(bfr.readLine());
        m = Integer.parseInt(stk.nextToken());
        n = Integer.parseInt(stk.nextToken());
        h = Integer.parseInt(stk.nextToken());
        map = new int[h][n][m]; visited = new boolean[h][n][m];
        for(int i=0; i<h; i++){
            for(int j=0; j<n; j++){
                stk = new StringTokenizer(bfr.readLine());
                for(int k=0; k<m; k++){
                    map[i][j][k] = Integer.parseInt(stk.nextToken());
                    if(map[i][j][k]==1) alreadyRipe.add(new Pos(i,j,k));
                }
            }
        }

        while(!alreadyRipe.isEmpty()){
            Pos cur = alreadyRipe.poll();
            for(int dir=0; dir<6; dir++){
                Pos next = new Pos(cur.height+move[dir][0], cur.row+move[dir][1], cur.col+move[dir][2]);
                if(isInRange(next.height,next.row,next.col)){
                    if(map[next.height][next.row][next.col]==0){
                        alreadyRipe.add(next);
                        map[next.height][next.row][next.col] = map[cur.height][cur.row][cur.col] + 1;
                    }
                }
            }
        }

        int max = 0;
        for(int i=0; i<h; i++){
            for(int j=0; j<n; j++){
                for(int k=0; k<m; k++){
                    if(map[i][j][k]==0) {
                        bfw.write("-1");
                        bfw.close();
                        return;
                    }
                    if(max<map[i][j][k])    max = map[i][j][k];
                }
            }
        }
        if(max==1)  bfw.write("0");
        else{
            bfw.write(String.valueOf(max - 1));
        }
        bfw.close();
    }

    static Boolean isInRange(int height, int row, int col) {
        if (height < 0 || height >= h || row < 0 || row >= n || col < 0 || col >= m) return false;
        return true;
    }

    static class Pos {
        int height;
        int row;
        int col;

        Pos(int h, int r, int c) {
            this.height = h;
            this.row = r;
            this.col = c;
        }
    }
}