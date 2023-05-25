import java.io.*;

public class boj2133 {
    static int[] dp;

    static Integer solution(int N){
        int answer = 0;
        dp[2] = 3;
        for(int i=2; i<=N/2; i++){
            int tmp = 2*i;

        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bfr.readLine());
        dp = new int[N+1];
        int answer = solution(N);
        System.out.println(answer);
    }
}