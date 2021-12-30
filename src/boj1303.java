import java.util.*;
import java.io.*;

public class boj1303 {
    static BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bfw;
    static StringTokenizer stk;
    static int N; // 가로
    static int M; // 세로
    static String input;
    static char[][] map;
    static boolean[][] visited;
    static int[] directionRow = { -1, 1, 0, 0}; // 상하좌우 순서
    static int[] directionCol = { 0, 0, -1, 1};
    static int ally = 0;
    static int enemy = 0;
    static int count = 0;

    static void dfs(int row, int col, char whoIsIt){
        visited[row][col] = true;
        count += 1;

        for(int i=0; i<4; i++){
            int newRow = row + directionRow[i];
            int newCol = col + directionCol[i];
            if(0<=newRow && newRow<M && 0<=newCol && newCol<N && map[newRow][newCol] == whoIsIt && !visited[newRow][newCol]){
                dfs(newRow, newCol, map[newRow][newCol]);
            }
        }
    }

    public static void main(String args[]) throws IOException {
        stk = new StringTokenizer(bfr.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        map = new char[M][N];
        visited = new boolean[M][N];

        for(int i=0; i<M; i++){
            String s = bfr.readLine();
            map[i] = s.toCharArray();
        }

        for(int row=0; row<M; row++){
            for(int col=0; col<N; col++){
                if(!visited[row][col]){ // 아직 방문하지 않은 녀석들을 차례로 순회해주자
                    count = 0;
                    dfs(row, col, map[row][col]);

                    if(map[row][col]=='W') // 아군이면 ally에 추가해주고
                        ally += count*count;
                    else // 적구이면 enemy 에 추가해주자
                        enemy += count*count;
                }
            }
        }
        bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        bfw.write(String.valueOf(ally) + " " + String.valueOf(enemy));
        bfw.close();
    }
}