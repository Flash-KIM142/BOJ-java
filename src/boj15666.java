// 2023.10.18 backtracking

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class boj15666 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        List<Integer> list = new ArrayList<>();
        for(int i=0; i<N; i++){
            int num = sc.nextInt();
            if(list.contains(num))  continue;
            list.add(num);
        }

        int[] bt = new int[M];
        Collections.sort(list);

        backtracking(list, 0, 0, M, bt);
    }

    public static void backtracking(List<Integer> list, int start, int depth, int M, int[] bt){
        if(depth==M){
            for(int i=0; i<M; i++){
                System.out.print(bt[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i=start; i<list.size(); i++){
            bt[depth] = list.get(i);
            backtracking(list, start, depth + 1, M, bt);
            start += 1;
        }
    }
}