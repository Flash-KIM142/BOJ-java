// dp. 2023.08.01

import java.util.Scanner;

public class boj2579re {

    static int N;
    static int[] steps = new int[301];
    static int[] dp = new int[301];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        for (int i = 0; i < N; i++) steps[i+1] = sc.nextInt();

        dp[1] = steps[1];
        dp[2] = steps[1] + steps[2];
        dp[3] = Math.max(steps[1]+steps[3], steps[2]+steps[3]);

        for(int i=4; i<=N; i++)
            dp[i] = Math.max(dp[i - 2] + steps[i], dp[i - 3] + steps[i-1] + steps[i]);

        System.out.println(dp[N]);
    }
}