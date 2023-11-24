// 2023.11.24 이분 탐색

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj12015re {

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bfr.readLine());

        int[] ary = new int[N];
        StringTokenizer st = new StringTokenizer(bfr.readLine());
        int idx = 0;
        while (st.hasMoreTokens()) {
            ary[idx++] = Integer.parseInt(st.nextToken());
        }

        List<Integer> result = new ArrayList<>();
        result.add(ary[0]);
        for (int i = 1; i < N; i++) {
            if (result.get(result.size() - 1) < ary[i]) {
                result.add(ary[i]);
                continue;
            }

            int l = 0;
            int r = result.size() - 1;
            while (l < r) {
                int mid = (l + r) / 2;

                if (ary[i] > result.get(mid)) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }

            result.set(l, ary[i]);
        }

        System.out.println(result.size());
    }
}