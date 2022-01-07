import java.util.*;
import java.io.*;

public class boj11722 {
    static int n, ary[], dp[], answer=-1;

    static void DP(){
        dp[0] = 1;
        for(int i=1; i<n; i++){
            dp[i] = 1;
            for(int j=0; j<i; j++){
                if(ary[j]>ary[i] && dp[j]+1>=dp[i])
                    dp[i] = dp[j] + 1;
            }
        }

        for(int i=0; i<n; i++){
            answer = Math.max(answer, dp[i]);
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(bfr.readLine());
        n = Integer.parseInt(stk.nextToken());
        ary = new int[n+1];
        dp = new int[n+1];
        stk = new StringTokenizer(bfr.readLine());
        for(int i=0; i<n; i++){
            ary[i] = Integer.parseInt(stk.nextToken());
        }
        DP();
        System.out.println(answer);
    }
}