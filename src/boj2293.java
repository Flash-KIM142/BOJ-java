import java.io.*;
import java.util.*;

public class boj2293 {
    static int n,k;
    static int[] num;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(bfr.readLine());
        n = Integer.parseInt(stk.nextToken());
        k = Integer.parseInt(stk.nextToken());
        num = new int[n+1];
        dp = new int[k+1];
        dp[0] = 1;

        for(int i=1; i<=n; i++) {
            num[i] = Integer.parseInt(bfr.readLine());
            for(int j=num[i]; j<=k; j++){
                dp[j] += dp[j-num[i]];
            }
        }

        System.out.println(dp[k]);
    }
}