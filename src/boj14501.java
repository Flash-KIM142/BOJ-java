import java.io.*;
import java.util.*;

public class boj14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        int N = Integer.parseInt(bfr.readLine());
        int[] time = new int[N];
        int[] price = new int[N];

        for(int i=0; i<N; i++){
            stk = new StringTokenizer(bfr.readLine());
            time[i] = Integer.parseInt(stk.nextToken());
            price[i] = Integer.parseInt(stk.nextToken());
        }

        int[] dp = new int[N+1];
        for(int i=N-1; i>=0; i--){
            if(i+time[i]>N) dp[i] = dp[i+1];
            else    dp[i] = Math.max(dp[i+1], dp[i+time[i]]+price[i]);
        }

        System.out.println(dp[0]);
    }

}
