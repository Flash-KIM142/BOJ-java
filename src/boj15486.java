// 2024.01.05 dp

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj15486 {

    static int N;
    static int[][] table;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bfr.readLine());
        table = new int[N + 1][2];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(bfr.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            table[i][0] = t;
            table[i][1] = p;
        }

        dp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            if (i + table[i][0] - 1 <= N) {
                dp[i + table[i][0] - 1] = Math.max(dp[i - 1] + table[i][1], dp[i + table[i][0] - 1]);
            }
            dp[i] = Math.max(dp[i], dp[i - 1]);
        }

        System.out.println(dp[N]);
    }
}