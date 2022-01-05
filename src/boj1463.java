import java.util.*;
import java.io.*;

public class boj1463 {
    static int n, dp[] = new int[1000001];

    static void bfs(int n) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{n, 0});

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int curNum = cur[0];
                int curCnt = cur[1];

                if (curNum == 1) return;

                /** 3으로 나누기 */
                if (curNum % 3 == 0 && dp[curNum / 3] == -1) {
                    dp[curNum / 3] = curCnt + 1;
                    q.add(new int[]{curNum / 3, curCnt + 1});
                }

                /** 2로 나누기 */
                if (curNum % 2 == 0 && dp[curNum / 2] == -1) {
                    dp[curNum / 2] = curCnt + 1;
                    q.add(new int[]{curNum / 2, curCnt + 1});
                }

                /** 1 빼기 */
                if (dp[curNum - 1] == -1) {
                    dp[curNum - 1] = curCnt + 1;
                    q.add(new int[]{curNum - 1, curCnt + 1});
                }
            }
        }
    }

    static int DP(int n) {
        dp[1] = 0;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            if (i % 2 == 0)
                dp[i] = Math.min(dp[i], dp[i/2]+1);
            if (i % 3 == 0)
                dp[i] = Math.min(dp[i], dp[i/3]+1);
        }
        return dp[n];
    }

    public static void main(String args[]) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bfr.readLine());
        for (int i = 0; i < 1000001; i++)
            dp[i] = -1;
        dp[n] = 0;

        /** BFS 로도 풀 수 있다 */
//        bfs(n);
//        System.out.println(dp[1]);

        /** DP 로 풀 경우 */
        System.out.println(DP(n));
    }
}