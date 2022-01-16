import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj15686 {
    static int n,m, minCityChickenDistance = Integer.MAX_VALUE;
    static int[][] map;
    static ArrayList<Pos> house = new ArrayList<>(), chicken = new ArrayList<>();
    static boolean[] chickenVisited;

    public static void main(String args[]) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(bfr.readLine());
        n = Integer.parseInt(stk.nextToken());  m = Integer.parseInt(stk.nextToken());
        map = new int[n+1][n+1];
        for(int i=1; i<=n; i++){
            stk = new StringTokenizer(bfr.readLine());
            for(int j=1; j<=n; j++) {
                map[i][j] = Integer.parseInt(stk.nextToken());
                if(map[i][j]==2) { // 치킨집 좌표 추가
                    chicken.add(new Pos(i,j));
                }
                else if(map[i][j]==1){ // 가정집 좌표 추가
                    house.add(new Pos(i,j));
                }
            }
        }

        chickenVisited = new boolean[chicken.size()];
        backTracking(0,0);

        bfw.write(String.valueOf(minCityChickenDistance));
        bfw.close();
    }

    static void backTracking(int idx, int cnt){
        if(cnt==m){
            int cityChickenDistance = 0;
            for(int i=0; i<house.size(); i++){
                int eachChickenDistance = Integer.MAX_VALUE;
                for(int j=0; j<chicken.size(); j++){
                    if(chickenVisited[j]){
                        int tmpDistance = Math.abs(house.get(i).row - chicken.get(j).row) + Math.abs(house.get(i).col - chicken.get(j).col);
                        eachChickenDistance = Math.min(eachChickenDistance, tmpDistance);
                    }
                }
                cityChickenDistance += eachChickenDistance;
            }
            minCityChickenDistance = Math.min(minCityChickenDistance, cityChickenDistance);
        }
        else{
            for (int i = idx; i < chicken.size(); i++) {
                if (!chickenVisited[i]) {
                    chickenVisited[i] = true;
                    backTracking(i + 1, cnt + 1);
                    chickenVisited[i] = false;
                }
            }
        }
    }

    static class Pos {
        int row; int col;
        Pos(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
}