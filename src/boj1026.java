// greedy. 2023.08.28

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class boj1026 {

    static int N;
    static Integer[] A,B;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        A = new Integer[N];
        B = new Integer[N];

        for (int i = 0; i < N; i++) A[i] = sc.nextInt();
        for (int i = 0; i < N; i++) B[i] = sc.nextInt();

        Arrays.sort(A);
        Arrays.sort(B, Collections.reverseOrder());

        int res = 0;
        for(int i=0; i<N; i++)  res += A[i] * B[i];
        System.out.println(res);
    }
}