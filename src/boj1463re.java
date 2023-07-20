// dp. 2023.07.20

import java.util.Scanner;

public class boj1463re {

    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        int[] dp = new int[1000001];
        for(int i=1; i<=n; i++) dp[i] = Integer.MAX_VALUE;
        dp[n] = 0;

        while(true){
            if(n%3==0) {
                dp[n / 3] = Math.min(dp[n/3], dp[n] + 1);
                if(n/3==1)  break;
            }
            if(n%2==0) {
                dp[n / 2] = Math.min(dp[n/2], dp[n] + 1);
                if(n/2==1)  break;
            }
            dp[n-1] = Math.min(dp[n-1], dp[n]+1);
            if(n-1<=1)  break;

            n--;
        }

        System.out.println(dp[1]);
    }
}