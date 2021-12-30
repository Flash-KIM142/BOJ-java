import java.util.*;
import java.io.*;

class pos{
    int row, col;

    public pos(int row, int col){
        this.row = row;
        this.col = col;
    }
}

public class boj2178 {
    static int N,M;
    static char[][] map;
    static boolean[][] visited;
    static int[][] count;
    static int[] directionRow = { -1, 1, 0, 0}; // 상하좌우 순서
    static int[] directionCol = { 0, 0, -1, 1};
    static Queue<pos> q = new LinkedList<>();

    static void bfs(){
        pos cur = new pos(0,0);
        q.offer(cur);
        visited[0][0] = true;

        while(!q.isEmpty()){
            pos tmp = q.poll();
            int row = tmp.row;
            int col = tmp.col;

            for(int i=0; i<4; i++){
                int newRow = row + directionRow[i];
                int newCol = col + directionCol[i];

                if(newRow<0 || N<=newRow || newCol<0 || M<=newCol)
                    continue;
                if(visited[newRow][newCol] || map[newRow][newCol]=='0')
                    continue;

                count[newRow][newCol] = count[row][col] + 1;
                visited[newRow][newCol] = true;
                q.offer(new pos(newRow, newCol));
            }
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(bfr.readLine());

        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M];
        count = new int[N][M];

        for(int row=0; row<N; row++){
            String s = bfr.readLine();
            map[row] = s.toCharArray();
        }

        count[0][0] = 1;
        bfs();
        bfw.write(String.valueOf(count[N-1][M-1]));
        bfw.close();
    }
}
