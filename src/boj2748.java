import java.util.*;
import java.io.*;

public class boj2748 {
    static int n;
    static long[] dp = new long[91];

    static long fib(int n){
        if(dp[n]==-1)
            dp[n] = fib(n-1) + fib(n-2);
        return dp[n];
    }

    public static void main(String args[]) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bfr.readLine());
        for(int i=0; i<91; i++)
            dp[i] = -1;
        dp[0] = 0; dp[1] = 1;
        System.out.println(fib(n));
    }
}