import java.io.*;
import java.util.StringTokenizer;

public class boj1965 {
    static int n;
    static int[] num;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bfr.readLine());
        num = new int[n];
        dp = new int[n];
        dp[n-1] = 1;

        StringTokenizer stk = new StringTokenizer(bfr.readLine());
        for(int i=0; i<n; i++)  num[i] = Integer.parseInt(stk.nextToken());

        int answer = dp[n-1];
        for(int i=n-2; i>=0; i--){
            int cur = num[i];
            int max = 0;
            for(int j=i+1; j<n; j++){
                if(cur<num[j])
                    max = Math.max(max,dp[j]);
            }
            dp[i] = max + 1;
            answer = Math.max(dp[i], answer);
        }
        System.out.println(answer);
    }
}