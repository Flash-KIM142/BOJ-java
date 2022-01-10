import java.util.*;
import java.io.*;

public class boj8979 {
    public static void main(String args[]) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(bfr.readLine());
        int n = Integer.parseInt(stk.nextToken());
        Nation[] nations = new Nation[n+1];
        int k = Integer.parseInt(stk.nextToken());

        Nation targetNation = new Nation(); int targetRank=1;
        for(int i=0; i<n; i++){
            stk = new StringTokenizer(bfr.readLine());
            nations[i] = new Nation(Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken()));
            if(nations[i].id == k)  targetNation = nations[i];
        }

        for(int i=0; i<n; i++){
            if(nations[i].id == k)  continue;
            else{
                if(targetNation.gold<nations[i].gold) targetRank++;
                if(targetNation.gold==nations[i].gold && targetNation.silver<nations[i].silver) targetRank++;
                if(targetNation.gold==nations[i].gold && targetNation.silver==nations[i].silver &&
                targetNation.bronze<nations[i].bronze)  targetRank++;
            }
        }

        bfw.write(String.valueOf(targetRank));
        bfw.close();
    }

    static class Nation{
        int id;
        int gold;
        int silver;
        int bronze;
        public Nation(){}
        public Nation(int id, int gold, int silver, int bronze){
            this.id = id;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }
    }
}