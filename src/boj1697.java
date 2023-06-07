/* 2023.06.07 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj1697 {

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(bfr.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int K = Integer.parseInt(stk.nextToken());
        boolean[] visited = new boolean[100001];

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{N, 0});
        visited[N] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int curPos = cur[0];
            int curCnt = cur[1];

            if(curPos==K){
                System.out.println(curCnt);
                return;
            }

            if(curPos-1>=0 && !visited[curPos-1]){
                q.add(new int[]{curPos - 1, curCnt + 1});
                visited[curPos-1] = true;
            }

            if(curPos+1<=100000 && !visited[curPos+1]){
                q.add(new int[]{curPos + 1, curCnt + 1});
                visited[curPos+1] = true;
            }

            if(curPos*2<=100000 && !visited[curPos*2]){
                q.add(new int[]{curPos * 2, curCnt + 1});
                visited[curPos*2] = true;
            }
        }
    }
}