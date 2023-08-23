// dp. 2023.08.23

import java.util.*;

public class boj12852 {

    static int N;
    static int[] cnt = new int[1000001];
    static int[] prev = new int[1000001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        cnt[1] = 0; prev[1] = 0;
        cnt[2] = 1; prev[2] = 1;
        cnt[3] = 1; prev[3] = 1;
        for(int i=4; i<=N; i++){
            cnt[i] = cnt[i-1] + 1;
            prev[i] = i-1;

            if(i%2==0 && cnt[i]>cnt[i/2]+1){
                cnt[i] = cnt[i/2] + 1;
                prev[i] = i/2;
            }

            if(i%3==0 && cnt[i]>cnt[i/3]+1){
                cnt[i] = cnt[i/3] + 1;
                prev[i] = i/3;
            }
        }

        System.out.println(cnt[N]);

        int cur = N;
        while(true){
            System.out.print(cur + " ");
            if(cur==1)  break;
            cur = prev[cur];
        }
    }
}