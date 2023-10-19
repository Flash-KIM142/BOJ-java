// 2023.10.18 backtracking

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj1941 {

    static int[][] map = new int[5][5];
    static int answer = 0;
    static int[] dirR = {-1,1,0,0};
    static int[] dirC = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        List<Pos> posList = new ArrayList<>();
        for(int i=0; i<5; i++){
            String s = bfr.readLine();
            for(int j=0; j<5; j++){
                if(s.charAt(j)=='S')    map[i][j] = 1;
                else map[i][j] = 0;

                Pos tmp = new Pos(i,j);
                if(!posList.contains(tmp))  posList.add(tmp);
            }
        }

        backtracking(posList, new Pos[7], 0, 0);
        System.out.println(answer);
    }

    public static void backtracking(List<Pos> list, Pos[] bt, int start, int depth){
        if(depth==7){
            int tmp = 0;
            for(Pos p: bt){
                tmp += map[p.r][p.c];
            }
            if(tmp>=4) {
                if(checkAdjacent(bt)){
                    answer++;
                }
            }

            return;
        }

        for(int i=start; i<25; i++){
            bt[depth] = list.get(i);
            backtracking(list, bt, i+1, depth+1);
        }
    }

    public static boolean checkAdjacent(Pos[] bt){
        Set<Pos> visitedPos = new HashSet<>();
        Queue<Pos> q = new LinkedList<>();
        q.add(bt[0]);
        visitedPos.add(bt[0]);

        while(!q.isEmpty()){
            Pos cur = q.poll();

            for(int d=0; d<4; d++){
                Pos nxt = new Pos(cur.r + dirR[d], cur.c + dirC[d]);

                if(nxt.r<0 || nxt.r>=5 || nxt.c<0 || nxt.c>=5)  continue;
                if(visitedPos.contains(nxt))    continue;

                for(int i=0; i<7; i++){
                    if(bt[i].equals(nxt)) {
                        visitedPos.add(nxt);
                        q.add(nxt);
                    }
                }
            }
        }

        return visitedPos.size()==7;
    }

    static class Pos{
        int r;
        int c;

        public Pos(int r, int c){
            this.r = r;
            this.c = c;
        }

        @Override
        public boolean equals(Object obj){
            if(this==obj)   return true;
            if(obj==null || getClass() != obj.getClass())  return false;

            Pos cmp = (Pos) obj;
            return this.r==cmp.r && this.c==cmp.c;
        }

        @Override
        public int hashCode(){
            return Objects.hash(r,c);
        }
    }
}