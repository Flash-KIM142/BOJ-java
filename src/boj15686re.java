// simulation. 2023.07.19

import java.util.*;

public class boj15686re {

    static int N,M;
    static int ans = 999999999;
    static int[][] map;
    static List<int[]> chickenList = new ArrayList<>();
    static List<int[]> houseList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N+1][N+1];

        int total_chicken = 0;
        for(int i=0; i<N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
                if(map[i][j]==2){
                    total_chicken++;
                    chickenList.add(new int[]{i,j});
                }
                else if(map[i][j]==1)   houseList.add(new int[]{i,j});
            }
        }

        boolean[] visited = new boolean[chickenList.size()];
        backtracking(0, 0, visited);

        System.out.println(ans);
    }

    static void getMinChickDist(List<int[]> selected_chicken){
        int sum = 0;

        for(int i=0; i< houseList.size(); i++){
            int[] cur_house = houseList.get(i);

            int closestChickDist = 999999999;
            for(int j=0; j<selected_chicken.size(); j++){
                int[] cur_chicken = selected_chicken.get(j);
                closestChickDist = Math.min(closestChickDist, Math.abs(cur_house[0] - cur_chicken[0]) + Math.abs(cur_house[1] - cur_chicken[1]));
            }

            sum += closestChickDist;
        }

        ans = Math.min(ans, sum);
    }

    static void backtracking(int idx, int cnt, boolean[] visited){
        if(cnt==M){
            List<int[]> tmp_list = new ArrayList<>();

            for(int i=0; i<visited.length; i++){
                if(!visited[i]) continue;

                tmp_list.add(chickenList.get(i));
            }

            getMinChickDist(tmp_list);
            return;
        }

        for(int i=idx; i<chickenList.size(); i++){
            if(visited[i])  continue;

            visited[i] = true;
            backtracking(i+1, cnt + 1, visited);
            visited[i] = false;
        }
    }
}