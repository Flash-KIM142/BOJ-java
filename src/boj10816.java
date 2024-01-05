// 2023.11.08 이분 탐색

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj10816 {

    static int N, M;
    static int[] nAry;

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bfr.readLine());
        nAry = new int[N];
        StringTokenizer st = new StringTokenizer(bfr.readLine());
        int idx = 0;
        while (st.hasMoreTokens()) {
            nAry[idx++] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nAry);

        M = Integer.parseInt(bfr.readLine());
        st = new StringTokenizer(bfr.readLine());
        StringBuilder sb = new StringBuilder();
        while (st.hasMoreTokens()) {
            int target = Integer.parseInt(st.nextToken());
            int l = lowerBound(target);
            int r = upperBound(target);

            sb.append(r - l).append(" ");
        }

        System.out.println(sb);
    }

    static int lowerBound(int target) {
        int l = 0;
        int r = N;

        while (l < r) {
            int mid = (l + r) / 2;

            if (target > nAry[mid]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l;
    }

    static int upperBound(int target) {
        int l = 0;
        int r = N;

        while (l < r) {
            int mid = (l + r) / 2;

            if (target < nAry[mid]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }
}