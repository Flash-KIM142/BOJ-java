// 2023.11.08 이분 탐색

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class boj18870 {

    static int N;
    static int[] ary;
    static List<Integer> sortedUniqueList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bfr.readLine());
        ary = new int[N];
        StringTokenizer st = new StringTokenizer(bfr.readLine());
        int idx = 0;
        Set<Integer> set = new HashSet<>();
        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            ary[idx] = num;

            if (set.contains(num)) {
                idx++;
                continue;
            }

            sortedUniqueList.add(num);
            set.add(num);
            idx++;
        }

        Collections.sort(sortedUniqueList);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(lowerBound(ary[i])).append(" ");
        }

        System.out.println(sb);
    }

    static int lowerBound(int num) {
        int l = 0;
        int r = sortedUniqueList.size();

        while (l < r) {
            int mid = (l + r) / 2;

            if (num > sortedUniqueList.get(mid)) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l;
    }
}