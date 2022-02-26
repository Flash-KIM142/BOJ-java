import java.io.*;
import java.util.StringTokenizer;

public class boj1520 {
    static int[][] map, dp;
    static int row,col;
    static int[][] move = { {0,-1}, {0,1}, {-1,0}, {1,0} };

    static int dfs(int r, int c){
        if(r==row-1 && c == col-1)
            return 1;
        else if(dp[r][c]!= -1)
            return dp[r][c];

        dp[r][c] = 0;
        for(int dir=0; dir<4; dir++){
            int nxt_r = r + move[dir][0];
            int nxt_c = c + move[dir][1];
            if(nxt_r<0 || nxt_r>=row || nxt_c<0 || nxt_c>=col)  continue; // 범위 밖이면 패스
            if(map[r][c] - map[nxt_r][nxt_c] <= 0)  continue; // 낮아지지 않으면 패스

            dp[r][c] += dfs(nxt_r, nxt_c);
        }

        return dp[r][c];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(bfr.readLine());
        row = Integer.parseInt(stk.nextToken());
        col = Integer.parseInt(stk.nextToken());
        map = new int[row][col];
        dp = new int[row][col];

        for(int i=0; i<row; i++){
            stk = new StringTokenizer(bfr.readLine());
            for(int j=0; j<col; j++){
                map[i][j] = Integer.parseInt(stk.nextToken());
                dp[i][j] = -1;
            }
        }

        System.out.println(dfs(0,0));
    }
}