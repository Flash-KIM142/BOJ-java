import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class boj14503 {
    static int n,m,r,c,d;
    static int cnt = 0;
    static int[][] map;
    static int[][] move = { {-1,0}, {0,1}, {1,0}, {0,-1} };

    public static void main(String args[]) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(bfr.readLine());
        n = Integer.parseInt(stk.nextToken()); m = Integer.parseInt(stk.nextToken());
        stk = new StringTokenizer(bfr.readLine());
        r = Integer.parseInt(stk.nextToken()); c = Integer.parseInt(stk.nextToken()); d = Integer.parseInt(stk.nextToken());
        map = new int[n][m];
        for(int i=0; i<n; i++){
            stk = new StringTokenizer(bfr.readLine());
            for(int j=0; j<m; j++)
                map[i][j] = Integer.parseInt(stk.nextToken());
        }

        clean(r,c,d);
        bfw.write(String.valueOf(cnt));
        bfw.close();
    }

    static void clean(int r, int c, int d){
        if(map[r][c]==0){
            map[r][c] = 2;
            cnt++;
        }

        boolean flag = false;
        int original_direction = d;
        for(int i=0; i<4; i++){
            int next_direction = (d+3)%4;
            int next_r = r + move[next_direction][0];
            int next_c = c + move[next_direction][1];

            if(next_r>=0 && next_r<n && next_c>=0 && next_c<m){
                if (map[next_r][next_c] == 0) {
                    clean(next_r, next_c, next_direction);
                    flag = true;
                    break;
                }
            }
            d = (d+3)%4;
        }

        if(!flag){
            int next_direction = (d+2)%4;
            int next_r = r + move[next_direction][0];
            int next_c = c + move[next_direction][1];

            if(next_r>=0 && next_r<n && next_c>=0 && next_c<m){
                if(map[next_r][next_c]!=1){
                    clean(next_r, next_c, original_direction);
                }
            }
        }
    }
}