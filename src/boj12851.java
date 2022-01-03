import java.util.*;
import java.io.*;

public class boj12851 {
    static int n, k, cnt = 0, time = 0;
    static boolean[] visited = new boolean[100001];

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(n);

        while (!q.isEmpty()) {
            int size = q.size();
            if (cnt != 0) break;

            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                visited[cur] = true;
                int next;

                next = cur - 1;
                if (next == k) cnt++;
                else if (next >= 0 && !visited[next]) q.add(next);

                next = cur + 1;
                if (next == k) cnt++;
                else if (next < 100001 && !visited[next]) q.add(next);

                next = cur * 2;
                if (next == k) cnt++;
                else if (next < 100001 && !visited[next]) q.add(next);
            }
            time++;
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(bfr.readLine());
        n = Integer.parseInt(stk.nextToken());
        k = Integer.parseInt(stk.nextToken());

        if (n >= k) {
            System.out.println((n - k) + "\n1");
            return;
        }

        bfs();
        System.out.println(time + "\n" + cnt);
    }
}