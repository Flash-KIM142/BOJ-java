import java.util.Scanner;

public class boj2631 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] list = new int[N];
        for(int i=0; i<N; i++)  list[i] = sc.nextInt();


        int[] dp = new int[N];
        dp[0] = 1;

        int res = 0;
        for(int i=1; i<N; i++){
            dp[i] = 1;
            for(int j=0; j<i; j++){
                if(list[i]>list[j])
                    dp[i] = Math.max(dp[i], dp[j]+1);
            }
            res = Math.max(dp[i], res);
        }

        System.out.println(N - res);
    }
}