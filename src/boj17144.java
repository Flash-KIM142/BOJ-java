import java.util.*;
import java.io.*;

public class boj17144 {
    static int R,C,T, whereCleanerIs, answer;
    static int[][] map;
    static int[][] direction = { {-1,0}, {1,0}, {0,-1}, {0,1} }; // 상 하 좌 우

    public static void main(String args[]) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(bfr.readLine());
        R = Integer.parseInt(stk.nextToken());  C = Integer.parseInt(stk.nextToken()); T = Integer.parseInt(stk.nextToken());
        map = new int[R][C];
        for(int i=0; i<R; i++){ // 초기 상태 입력 받자
            stk = new StringTokenizer(bfr.readLine());
            for(int j=0; j<C; j++) {
                map[i][j] = Integer.parseInt(stk.nextToken());
                if(map[i][j]==-1)   whereCleanerIs = i; // 두 번 나올테니까 밑에 위치한 녀석의 row를 저장할 거다
            }
        }

        for(int i=0; i<T; i++){
            int[][] after = Spread(map);
            after = Circulate(after);
            map = after;
            map[whereCleanerIs-1][1] = 0; // 공기 청정기 옆자리는 바람이 불면 당연히 비어있다.
            map[whereCleanerIs][1] = 0; // 위와 마찬가지
        }

        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++)
                answer += map[i][j];
        }
        answer += 2;
        bfw.write(String.valueOf(answer));
        bfw.close();
    }

    static int[][] Spread(int[][] before){ // 미세 먼지 확산 메소드
        int[][] after = new int[R][C];
        for(int i=0; i<R; i++)
            for(int j=0; j<C; j++)
                after[i][j] = before[i][j];

        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(before[i][j]==0 || before[i][j]==-1) continue; // 0이나 -1이면 그냥 지나침
                else{ // 미세먼지 있을 경우는 확산시켜주자
                    int contribute = before[i][j]/5; // 나눠줄 양
                    for(int k=0; k<4; k++){ // 사방으로 나눠주자
                        int nRow = i + direction[k][0];
                        int nCol = j + direction[k][1];

                        if(nRow<0 || nRow>=R || nCol<0 || nCol>=C)  continue; // 범위 벗어나면
                        if(nRow==whereCleanerIs-1 && nCol==0)    continue; // 공기 청정기1 자리면
                        if(nRow==whereCleanerIs && nCol==0)  continue; // 공기 청정기2 자리면

                        after[nRow][nCol] += contribute; // 사방에 주고
                        after[i][j] -= contribute; // 자기 자신은 줄어들고
                    }
                }
            }
        }

        return after;
    }

    static int[][] Circulate(int[][] before){ // 공기 청정기 가동 메소드
        int[][] after = new int[R][C];
        for(int i=0; i<R; i++)
            for(int j=0; j<C; j++)
                after[i][j] = before[i][j];
        /** 공기 청정기 윗 부분 */
        for(int i=0; i<whereCleanerIs; i++){
            for(int j=0; j<C; j++){
                if(i==0){ // 첫 번째 행 처리
                    if(j==0) { // 왼쪽 상단 꼭짓점은 아래로 내려가고
                        if(before[1][0]!=-1) // 만약 청정기 자리가 아니면
                            after[1][0] = before[i][j];
                    }
                    else // 왼쪽 꼭짓점을 제외하고는 왼쪽으로 한 칸씩만 옮겨가면 된다
                        after[i][j-1] = before[i][j];
                }
                else if(i==whereCleanerIs-1){ // 마지막 행 처리
                    if(j==0)    continue; // 청정기 자리임
                    if(j==C-1)  after[i-1][j] = before[i][j]; // 우측 하단 꼭짓점은 위로 한 칸 올리고
                    else // 나머지는 우측으로 한 칸씩만 옮기면 된다
                        after[i][j+1] = before[i][j];
                }
                else{ // 처음과 마지막 사이
                    if(j>0 && j<C-1)    continue;
                    if(j==0){ // 아래로 밀어
                        if(before[i+1][j]!=-1) // 한 칸 밑이 청정기가 아니라면 밀어주자
                            after[i+1][j] = before[i][j];
                    }
                    else if(j==C-1) // 위로 밀어
                        after[i-1][j] = before[i][j];
                }
            }
        }
        /** 공기 청정기 아랫 부분 */
        for(int i=whereCleanerIs; i<R; i++){
            for(int j=0; j<C; j++){
                if(i==whereCleanerIs){ // 첫 번째 행 처리
                    if(j==0)    continue; // 청정기 자리임
                    if(j==C-1)  after[i+1][j] = before[i][j]; // 우측 상단 꼭짓점은 한 칸 내리고
                    else // 그 외는 오른쪽으로 한 칸씩 옮기면 된다
                        after[i][j+1] = before[i][j];
                }
                else if(i==R-1){ // 마지막 행 처리
                    if(j==0)
                        if(before[i-1][j]!=-1) // 한 칸 위가 청정기가 아니라면 위로 밀어주자
                            after[i-1][j] = before[i][j];
                    else // 그 외는 왼쪽으로 한 칸씩 밀면 된다
                        after[i][j-1] = before[i][j];
                }
                else{ // 처음과 마지막 사이
                    if(j>0 && j<C-1)    continue; // 바람 안 닿는 부분
                    if(j==0) // 위로 밀어
                        if(before[i-1][j]!=-1)
                            after[i-1][j] = before[i][j];
                    else if(j==C-1) // 아래로 밀어
                        after[i+1][j] = before[i][j];
                }
            }
        }

        return after;
    }
}