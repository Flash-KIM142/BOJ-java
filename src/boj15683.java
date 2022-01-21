import java.util.*;
import java.io.*;

public class boj15683 {
    static int n,m,answer=0;
    static int[][] map,visited;
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String args[]) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(bfr.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        map = new int[n][m];
        for(int row=0; row<n; row++){ // 맵 입력 받자
            stk = new StringTokenizer(bfr.readLine());
            for(int col=0; col<m; col++)
                map[row][col] = Integer.parseInt(stk.nextToken());
        }
        visited = map.clone();

//        L1:
//        for(int row=0; row<n; row++)
//            for(int col=0; col<m; col++)
//                if(map[row][col]>0 && map[row][col]<6) {
//                    dfs(row, col);
//                    break L1;
//                }
        Recursion(0,0);

        bfw.write(String.valueOf(answer));
        bfw.close();
    }

    static void Recursion(int row, int col){
        int cur = map[row][col];
        if(cur==0 || cur==6){ // CCTV 아닌 곳 만났을 때
            if(col+1<m) Recursion(row, col+1);
            else if(row+1<n)    Recursion(row+1, 0);
            else{
                q.add(howManyZero(visited));
                return;
            }
        }
        else{ // CCTV 만났을 때
            if(cur==1){ // 1번 CCTV
                if(col-1>=0){ // 왼쪽으로 보고
                    for(int i=col-1; i>=0; i--){
                        if(map[row][i]!=6){ // 벽만 아니면
                            if(map[row][i]==0)  visited[row][i] = 7;
                        }
                        else{ // 벽 만나면
                            break;
                        }
                    }
                    if(col+1<m) Recursion(row, col+1);
                    else if(row+1<n)   Recursion(row+1, 0);
                    else{
                        q.add(howManyZero(visited));
                        return;
                    }

                    for(int i=col-1; i>=0; i--){
                        if(map[row][i]!=6){ // 벽만 아니면
                            if(visited[row][i]==7)  visited[row][i] = 0;
                        }
                        else{ // 벽 만나면
                            break;
                        }
                    }
                }

                if(col+1<n){ // 오른쪽으로 보고

                }

                if(row-1>=0){ // 위로 보고

                }

                if(row+1<n){ // 아래로 보고

                }
            }
            else if(cur==2){ // 2번 CCTV

            }
            else if(cur==3){ // 3번 CCTV

            }
            else if(cur==4){ // 4번 CCTV

            }
            else{ // 5번 CCTV

            }
        }
    }

    static Integer howManyZero(int[][] a){
        int result = 0;
        for(int row=0; row<n; row++){
            for(int col=0; col<m; col++){
                if(a[row][col]==0)
                    result++;
            }
        }
        return result;
    }
}
