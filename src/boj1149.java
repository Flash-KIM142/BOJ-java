// dp. 2023.08.01

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1149 {

    static int N;
    static int[][] dp = new int[1001][3];

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(bfr.readLine());
        N = Integer.parseInt(stk.nextToken());

        for(int i=1; i<=N; i++){
            stk = new StringTokenizer(bfr.readLine());
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + Integer.parseInt(stk.nextToken());
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + Integer.parseInt(stk.nextToken());
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + Integer.parseInt(stk.nextToken());
        }

        int result = Math.min(dp[N][0], dp[N][1]);
        result = Math.min(result, dp[N][2]);
        System.out.println(result);
    }
}