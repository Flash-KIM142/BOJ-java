// 2023.10.06 삼성 SW 역량 기출

import java.util.Scanner;

public class boj14888 {

    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] ary = new int[N];
        for (int i = 0; i < N; i++) ary[i] = sc.nextInt();

        int[] operators = new int[4];
        for (int i = 0; i < 4; i++) operators[i] = sc.nextInt();

        bt(0, N, operators, ary[0], ary);

        System.out.println(max);
        System.out.println(min);
    }

    static void bt(int depth, int N, int[] operators, int num, int[] ary){
        if(depth==N-1){
            min = Math.min(min, num);
            max = Math.max(max, num);
            return;
        }

        for(int i=0; i<4; i++){
            if(operators[i]>0){
                operators[i]--;

                switch (i){
                    case 0:
                        bt(depth + 1, N, operators, num + ary[depth + 1], ary);
                        break;
                    case 1:
                        bt(depth + 1, N, operators, num - ary[depth + 1], ary);
                        break;
                    case 2:
                        bt(depth + 1, N, operators, num * ary[depth + 1], ary);
                        break;
                    case 3:
                        bt(depth + 1, N, operators, num / ary[depth + 1], ary);
                        break;
                }

                operators[i]++;
            }
        }
    }
}