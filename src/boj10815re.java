// 2023.11.03 binary search

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj10815re {

    static int N, M;
    static int[] user, computer;
    static boolean[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bfr.readLine());
        user = new int[N];
        StringTokenizer st = new StringTokenizer(bfr.readLine());
        int idx = 0;
        while (st.hasMoreTokens()) {
            user[idx++] = Integer.parseInt(st.nextToken());
        }
        M = Integer.parseInt(bfr.readLine());
        computer = new int[M];
        result = new boolean[M];
        st = new StringTokenizer(bfr.readLine());
        idx = 0;
        while (st.hasMoreTokens()) {
            computer[idx++] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(user);
        binarySearch();

        for (int i = 0; i < M; i++) {
            if (result[i]) {
                System.out.print("1 ");
            } else {
                System.out.print("0 ");
            }
        }
    }

    public static void binarySearch() {
        for (int i = 0; i < M; i++) {
            int l = 0;
            int r = N - 1;
            int target = computer[i];

            int mid;
            while (l <= r) {
                mid = (l + r) / 2;

                if (target > user[mid]) {
                    l = mid + 1;
                } else if (target < user[mid]) {
                    r = mid - 1;
                } else if (target == user[mid]) {
                    result[i] = true;
                    break;
                }
            }
        }
    }
}