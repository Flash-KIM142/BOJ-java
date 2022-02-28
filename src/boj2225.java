import java.io.*;
import java.util.StringTokenizer;

public class boj2225 {
    static int N,K;
    static int[][] dp;

    static Integer solution(){
        dp = new int[K+1][N+1];
        for(int i=1; i<=K; i++)
            dp[i][1] = i;

        for(int i=1; i<=N; i++)
            dp[1][i] = 1;

        for(int i=2; i<=K; i++){
            for(int j=2; j<=N; j++){
                dp[i][j] = (dp[i][j-1] + dp[i-1][j]) % 1000000000;
            }
        }
        return dp[K][N];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(bfr.readLine());
        N = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());
        System.out.println(solution());
    }
}