import java.util.*;
import java.io.*;

public class boj15685 {
    static int N;
    static Info[] list;
    static int[][] map = new int[101][101];
    static int[][] move = { {0,1}, {-1,0}, {0,-1}, {1,0} };

    public static void main(String args[]) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(bfr.readLine());
        N = Integer.parseInt(stk.nextToken());
        list = new Info[N];
        for(int i=0; i<N; i++){ // 커브 정보 입력받자
            stk = new StringTokenizer(bfr.readLine());
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());
            int dir = Integer.parseInt(stk.nextToken());
            int gen = Integer.parseInt(stk.nextToken());
            list[i] = new Info(x,y,dir,gen);

            drawDots(list[i]);
        }

        bfw.write(String.valueOf(checkSquare()));
        bfw.close();
    }

    static void drawDots(Info target){ // 밟는 모든 점들 찍어주는 메소드
        int startX = target.x; int startY = target.y;
        int startDir = target.dir; int gen = target.gen;

        ArrayList<Integer> directionList = new ArrayList<>();
        directionList.add(startDir);
        /** 밟게될 모든 방향들 저장해주자 */
        for(int i=0; i<gen; i++){
            int size = directionList.size();
            int idx = size;
            for(int j=size-1; j>=0; j--){
                int tmpDir = directionList.get(j);
                directionList.add((tmpDir+1)%4); // 0->1, 1->2, 2->3, 3->0
            }
        }
        /** 이제 방향대로 쭉 점 찍어주자*/
        map[startY][startX] = 1;
        for(int i=0; i<directionList.size(); i++){
            int tmpDir = directionList.get(i);
            startY += move[tmpDir][0]; startX += move[tmpDir][1];
            map[startY][startX] = 1;
        }
    }

    static Integer checkSquare(){ // 찍힌 점들을 통해 정사각형 개수 세는 메소드
        int result = 0;
        for(int i=0; i<100; i++){
            for(int j=0; j<100; j++){
                if (map[i][j]==1 && map[i][j+1]==1 && map[i+1][j]==1 && map[i+1][j+1]==1) {
                    result++;
                }
            }
        }
        return result;
    }

    static class Info{
        int x,y,dir,gen;
        Info(int x, int y, int dir, int gen){
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.gen = gen;
        }
    }
}