// greedy. 2023.08.28

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class boj1931 {

    static int N;
    static int[][] booking;

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(bfr.readLine());
        booking = new int[N][2];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(bfr.readLine());
            booking[i][0] = Integer.parseInt(st.nextToken());
            booking[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(booking, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]==o2[1])    return o1[0] - o2[0];
                else    return o1[1] - o2[1];
            }
        });

        int cnt = 0;
        int prev_end = 0;
        for(int i=0; i<N; i++){
            if(prev_end<=booking[i][0]){
                prev_end = booking[i][1];
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}