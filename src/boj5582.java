import java.io.*;

public class boj5582 {
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        String input1 = bfr.readLine();
        String input2 = bfr.readLine();

        int[][] dp = new int[input1.length()+1][input2.length()+1];
        int result = 0;
        for(int i=1; i<=input1.length(); i++){
            for(int j=1; j<=input2.length(); j++){
                if(input1.charAt(i-1)==input2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    result = Math.max(result, dp[i][j]);
                }
            }
        }
        System.out.println(result);
    }
}