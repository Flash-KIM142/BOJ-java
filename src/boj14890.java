import java.util.*;
import java.io.*;

public class boj14890 {
    static int n,l,road=0;
    static int[][] map,extension;

    public static void main(String args[]) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(bfr.readLine());
        n = Integer.parseInt(stk.nextToken());
        l = Integer.parseInt(stk.nextToken());
        map = new int[n][n];
        extension = new int[n][n];
        for(int row=0; row<n; row++){
            stk = new StringTokenizer(bfr.readLine());
            for(int col=0; col<n; col++)
                map[row][col] = Integer.parseInt(stk.nextToken());
        }

        for(int i=0; i<n; i++){
            if(isRoadable(i, true)) road++; // 행 검사
            if(isRoadable(i, false)) road++; // 열 검사
        }

        bfw.write(String.valueOf(road));
        bfw.close();
    }

    static boolean isRoadable(int x, boolean rowOrCol){
        int[] height = new int[n];
        int[] extension = new int[n];
        for(int i=0; i<n; i++){
            if(rowOrCol)    height[i] = map[x][i]; // 행 검사
            else    height[i] = map[i][x]; // 열 검사
        }

        for(int i=0; i<n-1; i++){
            int displacement = height[i] - height[i+1];

            if(displacement==0) continue; // 똑같은 높이면 넘어가자
            else if(displacement==1){ // 좌측이 높고 우측이 낮을 때
                for(int j=i+1; j<=i+l; j++){
                    if(j>=n || height[i+1]!=height[j] || extension[j]==1)  return false;
                    extension[j] = 1;
                }
            }
            else if(displacement==-1){ // 좌측이 낮고 우측이 높을 때
                for(int j=i; j>i-l; j--){
                    if(j<0 || height[i]!=height[j] || extension[j]==1)  return false;
                    extension[j] = 1;
                }
            }
            else    return false;
        }

        return true;
    }
}