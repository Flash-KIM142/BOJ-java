import java.io.*;

public class boj1309 {
    static int N,answer;
    static int[][] dp;

    static void solution(){
        for(int i=2; i<=N; i++){
            dp[i][0] = dp[i-1][0] + dp[i-1][1] + dp[i-1][2];
            dp[i][1] = dp[i-1][0] + dp[i-1][2];
            dp[i][2] = dp[i-1][0] + dp[i-1][1];

            for(int j=0; j<3; j++)
                dp[i][j] %= 9901;
        }

        for(int i=0; i<3; i++)
            answer += dp[N][i];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bfr.readLine());
        dp = new int[N+1][3];
        dp[1][0] = 1;
        dp[1][1] = 1;
        dp[1][2] = 1;
        solution();

        System.out.println(answer);
    }
}