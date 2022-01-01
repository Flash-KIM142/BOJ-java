import java.util.*;
import java.io.*;

public class boj16930 {
    static int N,M,K;
    static char[][] map;
    static int[][] visited;
    static int startRow, startCol, endRow, endCol;
    static int[] directionRow = { -1, 1, 0 ,0 }; // 상하좌우
    static int[] directionCol = { 0, 0, -1, 1};

    static void bfs(){
        Queue<int []> q = new LinkedList<>();
        q.add(new int[]{ startRow, startCol });

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int curRow = cur[0];
            int curCol = cur[1];

            for(int i=0; i<4; i++){
                for(int j=1; j<=K; j++){
                    int newRow = curRow + directionRow[i]*j;
                    int newCol = curCol + directionCol[i]*j;

                    if(newRow>=1 && newRow<=N && newCol>=1 && newCol<=M && map[newRow][newCol]=='.'){
                        if(visited[newRow][newCol]==0){
                            visited[newRow][newCol] = visited[curRow][curCol] + 1;
                            if(newRow==endRow && newCol==endCol)
                                return;
                            q.add(new int[]{newRow, newCol});
                        }
                        else if(visited[newRow][newCol]<=visited[curRow][curCol])
                            break;
                    }
                    else
                        break;
                }
            }
        }
    }

    public static void main(String args[]) throws IOException{
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        stk = new StringTokenizer(bfr.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());

        map = new char[N+1][M+1];
        visited = new int[N+1][M+1];

        for(int i=1; i<=N; i++){
            String s = bfr.readLine();
            for(int j=1; j<=M; j++)
                map[i][j] = s.charAt(j-1);
        }

        stk = new StringTokenizer(bfr.readLine());
        startRow = Integer.parseInt(stk.nextToken());
        startCol = Integer.parseInt(stk.nextToken());
        endRow = Integer.parseInt(stk.nextToken());
        endCol = Integer.parseInt(stk.nextToken());


        bfs();

        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                bfw.write(String.valueOf(visited[i][j]));
            }
            bfw.newLine();
        }
        bfw.newLine();
        visited[endRow][endCol] = visited[endRow][endCol]==0 ? -1:visited[endRow][endCol];
        bfw.write(String.valueOf(visited[endRow][endCol]));
        bfw.close();
    }
}