import java.util.*;
import java.io.*;

public class boj14226 {
    static int S,answer;
    static boolean[][] visited = new boolean[2002][2002];
    static Queue<int[]> q = new LinkedList<>();

    static void bfs(){
        q.add(new int[]{1,0,0});
        visited[1][0] = true;

        while(!q.isEmpty()){
            int size = q.size();

            for(int i=0; i<size; i++){
                int[] cur = q.poll();
                int curScreen = cur[0];
                int curClip = cur[1];
                int curTime = cur[2];

                if(curScreen==S) {
                    answer = curTime;
                    return;
                }

                /** 복사 */
                if(curScreen!=curClip && !visited[curScreen][curScreen]){
                    q.add(new int[]{curScreen, curScreen, curTime + 1});
                    visited[curScreen][curScreen] = true;
                }

                /** 붙여넣기 */
                if (curClip!=0 && curScreen+curClip<1001 && !visited[curScreen+curClip][curClip]) {
                    q.add(new int[]{curClip + curScreen, curClip, curTime + 1});
                    visited[curClip + curScreen][curClip] = true;
                }

                /** 삭제 */
                if (curScreen >= 1 && !visited[curScreen-1][curClip]) {
                    q.add(new int[]{curScreen - 1, curClip, curTime + 1});
                    visited[curScreen-1][curClip] = true;
                }
            }
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(bfr.readLine());
        S = Integer.parseInt(stk.nextToken());

        bfs();
        System.out.println(answer);
    }
}