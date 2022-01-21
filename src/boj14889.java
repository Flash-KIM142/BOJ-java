import java.util.*;
import java.io.*;

public class boj14889 {
    static int n;
    static int min = Integer.MAX_VALUE;
    static int[][] level;
    static boolean[] visited;
    static LinkedList<Integer> team1 = new LinkedList<>(), team2 = new LinkedList<>();

    public static void main(String args[]) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(bfr.readLine());
        n = Integer.parseInt(stk.nextToken());
        level = new int[n][n];  visited = new boolean[n];
        for(int i=0; i<n; i++){
            stk = new StringTokenizer(bfr.readLine());
            for(int j=0; j<n; j++)
                level[i][j] = Integer.parseInt(stk.nextToken());
        }

        BackTracking(0,0);
        bfw.write(String.valueOf(min));
        bfw.close();
    }

    static void BackTracking(int idx, int cnt){
        if(cnt==n/2){
            team1.clear();  team2.clear();
            MakeTeams(); // 두 팀 모두 완성
            int team1_cap = 0;  int team2_cap = 0;
            team1_cap = GetTeamCap(team1);  team2_cap = GetTeamCap(team2);
            int gap = Math.abs(team1_cap - team2_cap);
            if(gap<min) min = gap;
        }
        else{
            for(int i=idx; i<n; i++){
                if(!visited[i]){
                    visited[i] = true;
                    BackTracking(i+1, cnt+1);
                    visited[i] = false;
                }
            }
        }
    }

    static void MakeTeams(){
        for(int i=0; i<n; i++){
            if(visited[i])    team1.add(i);
            else    team2.add(i);
        }
    }

    static Integer GetTeamCap(LinkedList<Integer> t){
        int cap = 0;
        for(int i=0; i<t.size()-1; i++){
            for(int j=i+1; j<t.size(); j++){
                cap += (level[t.get(i)][t.get(j)] + level[t.get(j)][t.get(i)]);
            }
        }
        return cap;
    }
}