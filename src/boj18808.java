// simulation 2023.07.17 실패

import java.util.Scanner;

public class boj18808 {

    static int N, M, K;
    static int[][] laptop;
    static int r, c;
    static int[][] sticker = new int[11][11];
    static int ans = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();

        laptop = new int[N][M];

        for (int i = 0; i < K; i++) {
            r = sc.nextInt();
            c = sc.nextInt();

            for (int j = 0; j < r; j++)
                for (int k = 0; k < c; k++)
                    sticker[j][k] = sc.nextInt();

            L1:
            for(int rot=0; rot<4; rot++){
                for(int j=0; j<=N-r; j++)
                    for(int k=0; k<=M-c; k++)
                        if(isStickable(j,k))
                            break L1;
                rotate();
            }
        }

        getResult();
        System.out.println(ans);
    }

    static boolean isStickable(int x, int y) {
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                if (laptop[x + i][y + j] == 1 && sticker[i][j] == 1)
                    return false;

        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                if (sticker[i][j] == 1)
                    laptop[x + i][y + j] = 1;
        return true;
    }

    static void getResult() {
        for (int r = 0; r < N; r++)
            for (int c = 0; c < M; c++)
                if (laptop[r][c] == 1) ans++;
    }

    static void rotate() {
        int[][] tmp_sticker = new int[11][11];

        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                tmp_sticker[i][j] = sticker[i][j];

        for(int i=0; i<c; i++)
            for(int j=0; j<r; j++)
                sticker[i][j] = tmp_sticker[r-j-1][i];

        int tmp = r;
        r = c;
        c = tmp;
    }
}