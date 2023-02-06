import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class boj17976 {
    static int[][] ary;
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        ary = new int[N][N];

        for(int i=0; i<N; i++){
            int pos = sc.nextInt();
            int len = sc.nextInt();
            ary[i][0] = pos;
            ary[i][1] = len;
        }

        Arrays.sort(ary, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0])    return o1[1] - o2[1];
                else    return o1[0] - o2[0];
            }
        });

        int maxLen = ary[N-1][0] + ary[N-1][1];
        int l = 0;
        int r = maxLen;

        while(l<=r){
            int mid = (l+r)/2;
            if(isPossible(mid)) l = mid + 1;
            else    r = mid - 1;
        }
        System.out.println(r);
    }

    static boolean isPossible(int len){
        int start = ary[0][0];
        for(int i=1; i<N; i++){
            if(start+len>(ary[i][0]+ary[i][1]))   return false;
            else    start = Math.max(start+len, ary[i][0]);
        }
        return true;
    }
}