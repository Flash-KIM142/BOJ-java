// 2023.11.03 dp

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj11053 {

    static int max = 1;
    static int n;
    static int[] ary;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bfr.readLine());
        ary = new int[n];
        dp = new int[n];
        Arrays.fill(dp, 1);
        StringTokenizer st = new StringTokenizer(bfr.readLine());
        int idx = 0;
        while (st.hasMoreTokens()) {
            ary[idx++] = Integer.parseInt(st.nextToken());
        }

        solve();
        System.out.println(max);
    }

    static void solve() {
        for (int i = 0; i < ary.length; i++) {
            int next = ary[i];
            for (int j = 0; j < i; j++) {
                int prev = ary[j];
                if (next > prev) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
    }
}