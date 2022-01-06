import java.util.*;
import java.io.*;

public class boj2579 {
    static int n,score[] = new int[301], max[] = new int[301];

    static void DP(){
        max[1] = score[1];
        max[2] = score[1] + score[2];
        max[3] = Math.max(score[1]+score[3], score[2]+score[3]);

        for(int i=4; i<n+1; i++)
            max[i] = Math.max(max[i-2] + score[i], max[i-3] + score[i-1] + score[i]);
    }

    public static void main(String args[]) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(bfr.readLine());
        n = Integer.parseInt(stk.nextToken());

        for(int i=1; i<=n; i++){
            stk = new StringTokenizer(bfr.readLine());
            score[i] = Integer.parseInt(stk.nextToken());
        }
        DP();
        System.out.println(max[n]);
    }
}