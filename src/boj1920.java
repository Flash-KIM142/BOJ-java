// 2023.11.08 이분탐색

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj1920 {

    static int N, M;
    static int[] nAry, mAry;


    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(bfr.readLine());
        nAry = new int[N];
        StringTokenizer st = new StringTokenizer(bfr.readLine());
        int idx = 0;
        while (st.hasMoreTokens()) {
            nAry[idx++] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nAry);

        M = Integer.parseInt(bfr.readLine());
        mAry = new int[M];
        st = new StringTokenizer(bfr.readLine());
        while (st.hasMoreTokens()) {
            int target = Integer.parseInt(st.nextToken());
            bfw.write(binarySearch(target) + "\n");
        }

        bfw.flush();
        bfw.close();
    }

    static int binarySearch(int target) {
        int l = 0;
        int r = N - 1;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (nAry[mid] < target) {
                l = mid + 1;
            } else if (nAry[mid] > target) {
                r = mid - 1;
            } else {
                return 1;
            }
        }

        return 0;
    }
}