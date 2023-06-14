/* 2023.06.14 */

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class boj11729 {
    static BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        System.out.println((1 << N) - 1);
        recur(1, 3, N);
        bfw.flush();
        bfw.close();
    }

    static void recur(int a, int b, int k) throws IOException {
        if (k == 1) {
            bfw.write(a + " " + b + "\n");
            return;
        }

        recur(a, 6 - a - b, k - 1);
        bfw.write(a + " " + b + "\n");
        recur(6 - a - b, b, k - 1);
    }
}