// 2023.11.08 이분탐색

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class boj2295 {

    static int N;
    static int[] ary;
    static List<Integer> sumOfTwoList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        ary = new int[N];

        for (int i = 0; i < N; i++) {
            ary[i] = sc.nextInt();
        }

        Set<Integer> sumOfTwoSet = new HashSet<>();
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                int sumOfTwo = ary[i] + ary[j];
                if (sumOfTwoSet.contains(sumOfTwo)) {
                    continue;
                }
                sumOfTwoList.add(sumOfTwo);
                sumOfTwoSet.add(sumOfTwo);
            }
        }

        Arrays.sort(ary);
        Collections.sort(sumOfTwoList);

        int result = 0;
        L:
        for (int i = N - 1; i >= 0; i--) { // 세 수의 합
            int sum = ary[i];
            for (int j = i - 1; j >= 0; j--) { // num3
                int sumOfTwo = sum - ary[j];
                if (binarySearch(sumOfTwo)) {
                    result = sum;
                    break L;
                }
            }
        }

        System.out.println(result);
    }

    static boolean binarySearch(int target) {
        int l = 0;
        int r = sumOfTwoList.size() - 1;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (target < sumOfTwoList.get(mid)) {
                r = mid - 1;
            } else if (target > sumOfTwoList.get(mid)) {
                l = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}