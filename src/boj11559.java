import java.util.LinkedList;
import java.util.Queue;
import java.io.*;

public class boj11559 {
    static char[][] map = new char[12][6];
    static boolean[][] visited;
    static int chainOccurence = 0;
    static int[][] move = { {-1,0}, {1,0}, {0,-1}, {0,1} };// 상하좌우
    static LinkedList<int[]> chainedPos = new LinkedList<>(), willBeDestroyed = new LinkedList<>();

    public static void main(String args[]) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0; i<12; i++){
            String input = bfr.readLine();
            for(int j=0; j<6; j++){
                map[i][j] = input.charAt(j);
            }
        }

        while(true){
            visited = new boolean[12][6];
            for(int i=0; i<12; i++)
                for(int j=0; j<6; j++)
                    bfs(i,j);
            if(willBeDestroyed.isEmpty())   break;
            else    chainOccurence++;
            fallDown();
        }

        bfw.write(String.valueOf(chainOccurence));
        bfw.close();
    }

    static void bfs(int row, int col){
        if(visited[row][col])   return; // 이미 방문한 지점이면 넘겨
        if(map[row][col]=='.')  return; // 빈 칸이면 넘겨
        visited[row][col] = true;

        Queue<int[]> q = new LinkedList<>();
        int chained_num = 1;
        q.add(new int[]{row,col});
        chainedPos.add(new int[]{row,col});
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int[] cur = q.poll();
                for(int dir=0; dir<4; dir++){
                    int n_row = cur[0] + move[dir][0]; int n_col = cur[1] + move[dir][1];
                    if(n_row<0 || n_row>11 || n_col<0 || n_col>5)   continue;
                    if(visited[n_row][n_col])   continue;
                    if(map[row][col]!=map[n_row][n_col])    continue;
                    q.add(new int[]{n_row,n_col});
                    visited[n_row][n_col] = true;
                    chainedPos.add(new int[]{n_row,n_col});
                    chained_num++;
                }
            }
        }
        if(chained_num<4)   chainedPos.clear(); // 4개 못 채웠으면 지워버리고
        willBeDestroyed.addAll(chainedPos); // 4개 이상이면 실제로 터뜨릴 리스트에 추가해주자
    }

    static void fallDown(){
        for(int[] pos: willBeDestroyed){ // 터뜨릴 목록 다 터뜨려서 빈 칸으로 만들어주자
            map[pos[0]][pos[1]] = '.';
        }
        willBeDestroyed.clear();

        Queue<Character> q = new LinkedList<>();
        for(int col=0; col<6; col++){ // 떨구는 건 col 별로 확인해주자
            for(int row=11; row>=0; row--){ // 아래서부터 위로 올라가며 색깔들 모아주고 다 모으면 맨 아래서부터 채워주자
                if(map[row][col]=='.')  continue; // 빈 칸이면 넘기고
                q.add(map[row][col]);
                map[row][col] = '.';
            }
            if(q.isEmpty()) continue;
            int size = q.size();
            for(int i=0; i<size; i++)
                map[11-i][col] = q.poll();
        }
    }
}