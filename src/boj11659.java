// dp. 2023.08.23

import java.util.Scanner;

public class boj11659 {

    static int N,M;
    static int[] nums = new int[100001];
    static int[] sum = new int[100001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        for(int i=0; i<N; i++)
            nums[i] = sc.nextInt();

        int tmp = 0;
        for(int i=0; i<N; i++){
            tmp += nums[i];
            sum[i] = tmp;
        }

        for(int i=0; i<M; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            if(a==b) System.out.println(nums[a-1]);
            else if(a==1) System.out.println(sum[b-1]);
            else System.out.println(sum[b-1] - sum[a-2]);
        }
    }
}