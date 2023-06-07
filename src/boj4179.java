/* 2023.06.01 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj4179 {
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상 하 좌 우
    static int R, C;

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bfr.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        char[][] map = new char[R][C];
        int[][] fireMap = new int[R][C];
        for (int i = 0; i < R; i++) Arrays.fill(fireMap[i], -1);
        int[][] humanMap = new int[R][C];
        for (int i = 0; i < R; i++) Arrays.fill(humanMap[i], -1);
        Queue<int[]> fireQ = new LinkedList<>();
        Queue<int[]> humanQ = new LinkedList<>();

        for (int r = 0; r < R; r++) {
            String row = bfr.readLine();
            for (int c = 0; c < C; c++) {
                map[r][c] = row.charAt(c);

                switch (map[r][c]) {
                    case 'J':
                        humanQ.add(new int[]{r, c});
                        humanMap[r][c] = 0;
                        break;

                    case 'F':
                        fireQ.add(new int[]{r, c});
                        fireMap[r][c] = 0;
                        break;
                }
            }
        }

        while (!fireQ.isEmpty()) {
            int[] cur = fireQ.poll();
            int cR = cur[0];
            int cC = cur[1];

            for (int d = 0; d < 4; d++) {
                int nR = cR + dir[d][0];
                int nC = cC + dir[d][1];

                if (isOutOfRange(nR, nC)) continue;
                if (fireMap[nR][nC] >= 0 || map[nR][nC] == '#') continue;

                fireQ.add(new int[]{nR, nC});
                fireMap[nR][nC] = fireMap[cR][cC] + 1;
            }
        }

        while (!humanQ.isEmpty()) {
            int[] cur = humanQ.poll();
            int cR = cur[0];
            int cC = cur[1];

            for (int d = 0; d < 4; d++) {
                int nR = cR + dir[d][0];
                int nC = cC + dir[d][1];

                if (isOutOfRange(nR, nC)) {
                    System.out.println(humanMap[cR][cC] + 1);
                    return;
                }
                if (humanMap[nR][nC] >= 0 || map[nR][nC] == '#') continue;
                if (fireMap[nR][nC] != -1 && fireMap[nR][nC] <= humanMap[cR][cC] + 1) continue;

                humanQ.add(new int[]{nR, nC});
                humanMap[nR][nC] = humanMap[cR][cC] + 1;
            }
        }

        System.out.println("IMPOSSIBLE");
    }

    static boolean isOutOfRange(int r, int c) {
        return r < 0 || r >= R || c < 0 || c >= C;
    }
}