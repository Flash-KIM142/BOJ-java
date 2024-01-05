// 2023.11.03 투포인터

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2559 {

    static int N, K;
    static int[] temperatureAry;

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bfr.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        temperatureAry = new int[N];

        st = new StringTokenizer(bfr.readLine());
        int idx = 0;
        while (st.hasMoreTokens()) {
            temperatureAry[idx++] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution());
    }

    public static int solution() {
        int prevSum = 0;
        for (int i = 0; i < K; i++) {
            prevSum += temperatureAry[i];
        }

        int max = prevSum;
        int leftIdx = 0;
        int rightIdx = K;

        while (rightIdx < N) {
            int nextSum = prevSum - temperatureAry[leftIdx] + temperatureAry[rightIdx];
            max = Math.max(max, nextSum);

            prevSum = nextSum;
            leftIdx++;
            rightIdx++;
        }

        return max;
    }
}