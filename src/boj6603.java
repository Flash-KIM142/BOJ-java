// 2023.10.18 backtracking

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj6603 {

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            StringTokenizer st = new StringTokenizer(bfr.readLine());
            int k = Integer.parseInt(st.nextToken());
            if(k==0)    return;

            int[] ary = new int[k];
            int idx = 0;
            while(st.hasMoreTokens()){
                ary[idx++] = Integer.parseInt(st.nextToken());
            }

            int[] bt = new int[6];
            boolean[] visited = new boolean[k];
            backtracking(ary, bt, k, 0, 0, visited);

            System.out.println();
        }
    }

    public static void backtracking(int[] ary, int[] bt, int k, int start, int depth, boolean[] visited){
        if(depth==6){
            Arrays.sort(bt);
            for(int i=0; i<6; i++){
                System.out.print(bt[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i=start; i<k; i++){
            if(!visited[i]){
                visited[i] = true;
                bt[depth] = ary[i];
                backtracking(ary, bt, k, i, depth + 1, visited);
                visited[i] = false;
            }
        }
    }
}