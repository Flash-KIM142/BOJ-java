// greedy. 2023.08.28

import java.util.Arrays;
import java.util.Scanner;

public class boj2217 {

    static int N;
    static int[] ary;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        ary = new int[N];

        for (int i = 0; i < N; i++) ary[i] = sc.nextInt();

        Arrays.sort(ary);

        int max = 0;
        for(int i=1; i<=N; i++){ // 총 몇 개의 로프를 사용할지
            max = Math.max(max, ary[N - i] * i);
        }

        System.out.println(max);
    }
}