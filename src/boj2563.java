import java.util.*;
import java.io.*;

public class boj2563 {
    public static void main(String args[]) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        int[][] map = new int[100][100];
        int S = 0;
        int n = Integer.parseInt(bfr.readLine());
        for(int i=0; i<n; i++){
            stk = new StringTokenizer(bfr.readLine());
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());

            for(int a=x; a<x+10; a++){
                for(int b=y; b<y+10; b++){
                    if(map[a][b]==1)    continue;
                    else    map[a][b] = 1;
                    S++;
                }
            }
        }

        bfw.write(String.valueOf(S));
        bfw.close();
    }
}