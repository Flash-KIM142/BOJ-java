import java.util.*;

public class boj2468 {

    static int answer = 0;
    static int N;
    static int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}}; // 상 하 좌 우

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        int maxHeight = 1;
        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
                maxHeight = Math.max(map[i][j], maxHeight);
            }
        }

        for (int h = 0; h <= maxHeight; h++) bfs(map, h);

        System.out.println(answer);
    }

    static void bfs(int[][] org, int h) {
        int cnt = 0;
        int[][] map = new int[N][N];
        boolean[][] visited = new boolean[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                map[i][j] = (org[i][j]<=h) ? 0 : 1;

        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j]==0)    continue; // 잠겼으면 패스
                if(visited[i][j])   continue; // 이미 방문했으면 패스

                cnt++;

                q.add(new int[]{i, j});
                visited[i][j] = true;

                while(!q.isEmpty()){
                    int[] pos = q.poll();
                    int curRow = pos[0];
                    int curCol = pos[1];

                    for(int d=0; d<4; d++){
                        int nxtRow = curRow + dir[d][0];
                        int nxtCol = curCol + dir[d][1];

                        if(!isInMap(nxtRow, nxtCol))    continue;
                        if(visited[nxtRow][nxtCol]) continue;
                        if(map[nxtRow][nxtCol]==0)  continue; // 잠겼으면 더이상 진출 X

                        q.add(new int[]{nxtRow, nxtCol});
                        visited[nxtRow][nxtCol] = true;
                    }
                }
            }
        }

        answer = Math.max(answer, cnt);
    }

    static boolean isInMap(int r, int c){
        return r>=0 && r<N && c>=0 && c<N;
    }
}