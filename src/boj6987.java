import java.util.*;
import java.io.*;

public class boj6987 {
    static int[] team1 = { 0,0,0,0,0,1,1,1,1,2,2,2,3,3,4 };
    static int[] team2 = { 1,2,3,4,5,2,3,4,5,3,4,5,4,5,5 };
    static int[][] matchResultInput = new int[6][3];
    static int[][] possibleMatchResult = new int[6][3];
    static boolean[] result = new boolean[4];
    static int totalNum = 0;

    public static void main(String args[]) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int tc=0; tc<4; tc++){
            StringTokenizer stk = new StringTokenizer(bfr.readLine());
            for(int team=0; team<6; team++){
                for(int winLose=0; winLose<3; winLose++)
                    matchResultInput[team][winLose] = Integer.parseInt(stk.nextToken());
            }
            /** 가능한 경우들을 대조해보자 */
            backTracking(tc, 0);
            if(result[tc])    bfw.write("1 ");
            else    bfw.write("0 ");
            matchResultInput = new int[6][3];   possibleMatchResult = new int[6][3];
        }

        bfw.close();
    }

    static void backTracking(int tc, int round){
        if(result[tc])  return;
        boolean flag = true;
        if(round==15){ // 15라운드 모두 끝났으면
            if(totalNum!=30){ // 애초에 모든 숫자합이 30도 안되면 바로 false
                flag = false;
                return;
            }
            else{
                for(int team=0; team<6; team++){
                    for(int winLose=0; winLose<3; winLose++){
                        if(matchResultInput[team][winLose]!=possibleMatchResult[team][winLose]) {
                            flag = false;
                            break;
                        }
                    }
                    if(!flag)   break;
                }
            }
            if(flag)    result[tc] = true;
            return;
        }

        int t1 = team1[round];  int t2 = team2[round];

        /** t1이 이기고 t2가 질 경우 */
        possibleMatchResult[t1][0]++;   possibleMatchResult[t2][2]++;   totalNum += 2;
        backTracking(tc, round+1);
        possibleMatchResult[t1][0]--;   possibleMatchResult[t2][2]--;   totalNum -= 2;

        /** t1과 t2가 비길 경우 */
        possibleMatchResult[t1][1]++;   possibleMatchResult[t2][1]++;   totalNum += 2;
        backTracking(tc, round+1);
        possibleMatchResult[t1][1]--;   possibleMatchResult[t2][1]--;   totalNum -= 2;

        /** t1이 지고 t2가 이길 경우 */
        possibleMatchResult[t1][2]++;   possibleMatchResult[t2][0]++;   totalNum += 2;
        backTracking(tc, round+1);
        possibleMatchResult[t1][2]--;   possibleMatchResult[t2][0]--;   totalNum -= 2;
    }
}