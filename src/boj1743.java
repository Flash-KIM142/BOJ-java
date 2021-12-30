import java.util.*;
import java.io.*;

public class boj1743 {
    static int N,M,K;
    static int[][] map;
    static boolean[][] visited;
    static int[] directionRow = { -1, 1, 0, 0}; // 상하좌우 순서
    static int[] directionCol = { 0, 0, -1, 1};
    static int answer;
    static int count;

    static void dfs(int row, int col){
        visited[row][col] = true;
        count += 1;

        for(int i=0; i<4; i++){
            int newRow = row + directionRow[i];
            int newCol = col + directionCol[i];

            if(newRow<1 || N<newRow || newCol<1 || M<newCol)
                continue;
            if(map[newRow][newCol]==0 || visited[newRow][newCol])
                continue;

            dfs(newRow, newCol);
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(bfr.readLine());

        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());
        map = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];

        for(int i=0; i<K; i++){
            stk = new StringTokenizer(bfr.readLine());
            int row = Integer.parseInt(stk.nextToken());
            int col = Integer.parseInt(stk.nextToken());
            map[row][col] = 1;
        }

        for(int row=1; row<=N; row++){
            for(int col=1; col<=M; col++){
                if(map[row][col]==1 && !visited[row][col]){
                    count = 0;
                    dfs(row, col);
                    answer = Integer.max(count, answer);
                }
            }
        }

        bfw.write(String.valueOf(answer));
        bfw.close();
    }
}
