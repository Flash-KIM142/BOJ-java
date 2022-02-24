import java.util.*;
import java.io.*;

public class boj11722 {
    static int n;
    static int[] input;
    static int[] dp;

    public static void main(String args[]) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(bfr.readLine());
        n = Integer.parseInt(stk.nextToken());
        stk = new StringTokenizer(bfr.readLine());

        input = new int[n];
        dp = new int[n];
        for(int i=0; i<n; i++)
            input[i] = Integer.parseInt(stk.nextToken());

        int answer = 1;
        for(int i=0; i<n; i++){
            dp[i] = 1;
            for(int j=0; j<i; j++){
                if(input[j]>input[i]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            answer = Math.max(answer, dp[i]);
        }
        System.out.println(answer);
    }
}