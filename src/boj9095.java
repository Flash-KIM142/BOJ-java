import java.util.*;
import java.io.*;

public class boj9095 {
    static int T,n,dp[] = new int[11];

    static int DP(int n){
        if(dp[n]!=0)    return dp[n];
        else{
            for(int i=4; i<n+1; i++)
                dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
            return dp[n];
        }
    }

    public static void main(String args[]) throws IOException{
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(bfr.readLine());
        T = Integer.parseInt(stk.nextToken());
        dp[1] = 1; dp[2] = 2; dp[3] = 4;
        for(int i=0; i<T; i++){
            stk = new StringTokenizer(bfr.readLine());
            n = Integer.parseInt(stk.nextToken());
            System.out.println(DP(n));
        }
    }
}