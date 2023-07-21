// dp. 2023.07.21

import java.util.Scanner;

public class boj9095re {

    static int[] dp = new int[11];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for(int i=0; i<t; i++){
            int n = sc.nextInt();
            System.out.println(dp(n));
        }
    }

    static int dp(int n){
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        if(n<=3)    return dp[n];

        for(int i=4; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        return dp[n];
    }
}