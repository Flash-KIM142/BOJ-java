import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.Iterator;

public class boj16235 {
    static int n,m,k;
    static int[][] feed, nutrition;
    static LinkedList<Tree> trees = new LinkedList<>();
    static Queue<Tree> dead_trees = new LinkedList<>();

    public static void main(String args[]) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(bfr.readLine());
        n = Integer.parseInt(stk.nextToken()); m = Integer.parseInt(stk.nextToken()); k = Integer.parseInt(stk.nextToken());
        feed = new int[n+1][n+1]; nutrition = new int[n+1][n+1];
        for(int i=1; i<=n; i++){
            stk = new StringTokenizer(bfr.readLine());
            for(int j=1; j<=n; j++){
                feed[i][j] = Integer.parseInt(stk.nextToken());
                nutrition[i][j] = 5;
            }
        }

        for(int i=0; i<m; i++){
            stk = new StringTokenizer(bfr.readLine());
            int r = Integer.parseInt(stk.nextToken());  int c = Integer.parseInt(stk.nextToken());  int age = Integer.parseInt(stk.nextToken());
            trees.add(new Tree(r,c,age));
        }

        afterKYears();
        bfw.write(String.valueOf(trees.size()));
        bfw.close();
    }

    static void afterKYears(){
        int year = 0;
        while(true){
            if(year==k) return;

            /** Spring */
            Iterator<Tree> it = trees.iterator();
            while(it.hasNext()){
                Tree cur_tree = it.next();
                int r = cur_tree.row;   int c = cur_tree.col;   int age = cur_tree.age;
                if(nutrition[r][c]-age<0){ // 먹이가 부족해요
                    dead_trees.add(cur_tree); // 그럼 죽어야지
                    it.remove();
                }
                else{ // 먹이 충분하면
                    nutrition[r][c] -= age;
                    cur_tree.age += 1; // 한 살 더 머겅
                }
            }

            /** Summer */
            while(!dead_trees.isEmpty()){
                Tree dead = dead_trees.poll();
                nutrition[dead.row][dead.col] += dead.age/2;
            }

            /** Autumn */
            int[][] move = { {-1,0}, {-1,1}, {0,1}, {1,1}, {1,0}, {1,-1}, {0,-1}, {-1,-1} };
            LinkedList<Tree> new_born = new LinkedList<>();
            for(Tree t: trees){
                int r = t.row; int c = t.col; int age = t.age;

                if(age%5 == 0){
                    for (int i = 0; i < 8; i++) {
                        int n_row = r + move[i][0];
                        int n_col = c + move[i][1];
                        if(n_row<1 || n_row>n || n_col<1 || n_col>n)    continue;
                        new_born.add(new Tree(n_row, n_col, 1));
                    }
                }
            }
            trees.addAll(0, new_born);

            /** Winter */
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++)
                    nutrition[i][j] += feed[i][j];
            }

            year++;
        }
    }

    static class Tree {
        int row; int col; int age;

        Tree(int r, int c, int age){
            this.row = r;
            this.col = c;
            this.age = age;
        }
    }
}