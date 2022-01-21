import java.util.*;
import java.io.*;

public class boj16236 {
    static int n;
    static int[][] map;
    static Fish shark;
    static LinkedList<Fish> fishes = new LinkedList<>();
    static int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상하좌우

    public static void main(String args[]) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(bfr.readLine());
        n = Integer.parseInt(stk.nextToken());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(bfr.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(stk.nextToken());
                if (map[i][j] == 9) shark = new Fish(i, j, 2);
                else if (map[i][j] != 0) fishes.add(new Fish(i, j, map[i][j]));
            }
        }
        Collections.sort(fishes, new Comparator<Fish>() {
            @Override
            public int compare(Fish o1, Fish o2) {
                return (o1.size > o2.size) ? +1 : -1;
            }
        });

        bfw.write(String.valueOf(Eat()));
        bfw.close();
    }

    static Integer Eat(){
        int total_move = 0;
        while(true) {
            /** 먹리스트를 작성해보자 */
            Iterator<Fish> it = fishes.iterator();
            LinkedList<Fish> eatable = new LinkedList<>();
            while (it.hasNext()) { // 먹리스트를 만들자
                Fish cur = it.next();
                if (cur.size < shark.size) { // 상어보다 작으면
                    if(GetDist(shark, cur)!=-1) // 도달할 수 있으면
                        eatable.add(cur); // 먹리스트에 올린다
                }
            }
            if(eatable.isEmpty())   break; // 먹을 수 있는 놈이 없으면 멈춰

            /** 먹을 타겟을 정하자 */
            Fish target = eatable.getFirst();
            for(int i=1; i< eatable.size(); i++){
                Fish possible_target = eatable.get(i);
                if(GetDist(shark, target) > GetDist(shark, possible_target)){
                    target = eatable.get(i);
                }
                else if(GetDist(shark, target) == GetDist(shark, possible_target)){
                    if(target.row > possible_target.row)    target = possible_target;
                    else if(target.row == possible_target.row)
                        if(target.col > possible_target.col)    target = possible_target;
                }
            }

            /** 먹자 */
            map[target.row][target.col] = 0; // 먹고
            total_move += GetDist(shark, target); // 이동 거리 더하고
            shark.row = target.row; shark.col = target.col; // 상어 옮겨주고
        }
        return total_move;
    }

    static Integer GetDist(Fish shark, Fish prey) {
        int cnt = 0;
        boolean[][] visited = new boolean[n][n];
        int cur_row = shark.row;
        int cur_col = shark.col;
        visited[cur_row][cur_col] = true;
        int dst_row = prey.row;
        int dst_col = prey.col;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{cur_row, cur_col});

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] tmp = q.poll();
                int r = tmp[0];
                int c = tmp[1];
                visited[r][c] = true;
                if (r == dst_row && c == dst_col) return cnt;

                for (int j = 0; j < 4; j++) {
                    int n_row = r + move[j][0];
                    int n_col = c + move[j][1];
                    if (n_row < 0 || n_row >= n || n_col < 0 || n_col >= n) continue;
                    if (map[n_row][n_col] > shark.size) continue;
                    q.add(new int[]{n_row, n_col});
                }
            }
            cnt++;
        }

        return -1;
    }

    static class Fish {
        int row;
        int col;
        int size;

        Fish(int r, int c, int size) {
            this.row = r;
            this.col = c;
            this.size = size;
        }
    }
}