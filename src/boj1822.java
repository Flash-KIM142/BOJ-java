// 2023.11.24 이분 탐색

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj1822 {

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bfr.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] aryA = new int[N];
        int[] aryB = new int[M];
        st = new StringTokenizer(bfr.readLine());
        int idx = 0;
        while (st.hasMoreTokens()) {
            aryA[idx++] = Integer.parseInt(st.nextToken());
        }
        idx = 0;
        st = new StringTokenizer(bfr.readLine());
        while (st.hasMoreTokens()) {
            aryB[idx++] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(aryA);
        Arrays.sort(aryB);

        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        L:
        for (int i = 0; i < N; i++) {
            int target = aryA[i];

            int l = 0;
            int r = M - 1;
            while (l <= r) {
                int mid = (l + r) / 2;

                if (target < aryB[mid]) {
                    r = mid - 1;
                } else if (target > aryB[mid]) {
                    l = mid + 1;
                } else {
                    continue L;
                }
            }
            sb.append(target).append(" ");
            cnt++;
        }

        System.out.println(cnt);
        System.out.println(sb);
    }
}