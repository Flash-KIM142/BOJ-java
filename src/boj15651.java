// 백트래킹

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class boj15651 {

    static int N,M;
    static int[] arr;
    static BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[M+1];

        backtracking(0);
        bfw.flush();
        bfw.close();
    }

    static void backtracking(int k) throws IOException {
        if(k==M){
            for(int i=0; i<M; i++)
                bfw.write(arr[i] + " ");
            bfw.write("\n");
            return;
        }

        for(int i=1; i<=N; i++){
            arr[k] = i;
            backtracking(k+1);
        }
    }
}