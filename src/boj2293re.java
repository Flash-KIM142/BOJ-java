// 2023.11.08 dp

import java.util.Scanner;

public class boj2293re {

    static int n, k;
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        dp = new int[k + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            int num = sc.nextInt();
            for (int j = num; j <= k; j++) {
                dp[j] += dp[j - num];
            }
        }

        System.out.println(dp[k]);
    }
}