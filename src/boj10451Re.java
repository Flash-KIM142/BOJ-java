import java.io.*;
import java.util.*;

public class boj10451Re {
    static int answer;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        int T = Integer.parseInt(bfr.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(bfr.readLine());
            int[] ary = new int[n + 1];
            stk = new StringTokenizer(bfr.readLine());
            for (int j = 1; j <= n; j++) {
                ary[j] = Integer.parseInt(stk.nextToken());
            }
            visited = new boolean[n+1];
            answer = 0;

            for(int j=1; j<=n; j++){
                if(!visited[j]){
                    dfs(j, ary);
                    answer++;
                }
            }

            System.out.println(answer);
        }
    }

    static void dfs(int start, int[] ary){
        visited[start] = true;

        int end = ary[start];
        if(!visited[end]){
            dfs(end, ary);
        }
    }
}
