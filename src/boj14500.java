import java.util.*;
import java.io.*;

public class boj14500 {
    static int N,M,max;
    static int[][] map = new int[500][500];
    static boolean[][] visited = new boolean[500][500];
    static int[] directionRow = { -1, 1, 0 , 0};
    static int[] directionCol = { 0 , 0, 1, -1};

    public static void main(String args[]) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(bfr.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        for(int i=0; i<N; i++){
            stk = new StringTokenizer(bfr.readLine());
            for(int j=0; j<M; j++)
                map[i][j] = Integer.parseInt(stk.nextToken());
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                visited[i][j] = true;
                dfs(i,j,map[i][j],0);
                visited[i][j] = false;

                if(i+1<N && j+2<M) max = (max<map[i][j]+map[i][j+1]+map[i+1][j+1]+map[i][j+2] ? map[i][j]+map[i][j+1]+map[i+1][j+1]+map[i][j+2] : max);
                if(i-2>=0 && j+1<M) max = (max<map[i][j]+map[i-1][j]+map[i-2][j]+map[i-1][j+1] ? map[i][j]+map[i-1][j]+map[i-2][j]+map[i-1][j+1] : max);
                if(i-1>=0 && j-2>=0) max = (max<map[i][j]+map[i][j-1]+map[i][j-2]+map[i-1][j-1] ? map[i][j]+map[i][j-1]+map[i][j-2]+map[i-1][j-1] : max);
                if(i+2<N && j-1>=0) max = (max<map[i][j]+map[i+1][j]+map[i+2][j]+map[i+1][j-1] ? map[i][j]+map[i+1][j]+map[i+2][j]+map[i+1][j-1] : max);
            }
        }

        bfw.write(String.valueOf(max));
        bfw.close();
    }

    static void dfs(int row, int col, int sum, int cnt){
        if(cnt==3){
            max = Math.max(max, sum);
            return;
        }

        for(int i=0; i<4; i++){
            int nRow = row + directionRow[i];
            int nCol = col + directionCol[i];

            if(nRow>=0 && nRow<N && nCol>=0 && nCol<M && !visited[nRow][nCol]){
                visited[nRow][nCol] = true;
                dfs(nRow, nCol, sum + map[nRow][nCol], cnt+1);
                visited[nRow][nCol] = false;
            }
        }
    }
}