// dp. 2023.08.018

import java.util.Scanner;

public class boj11726 {

    static int n;
    static final int num = 10007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        long[] dp = new long[1001];

        dp[1] = 1L;
        dp[2] = 2L;

        if(n<=2) System.out.println(dp[n]);
        else{
            for(int i=3; i<=n; i++) dp[i] = (dp[i-1] + dp[i-2])%num;

            System.out.println(dp[n]);
        }
    }
}