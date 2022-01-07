import java.io.*;
import java.util.*;

public class boj2490 {
    public static void main(String args[]) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        int zero, one;

        for(int i=0; i<3; i++){
            zero=0; one=0; // 등과 배 초기화
            stk = new StringTokenizer(bfr.readLine());
            for(int j=0; j<4; j++){
                int cur = Integer.parseInt(stk.nextToken());
                if(cur==0)  zero++;
                else    one++;
            }

            if(zero==1 && one==3)   bfw.write('A');
            else if(zero==2 && one==2)  bfw.write('B');
            else if(zero==3 && one==1)  bfw.write('C');
            else if(zero==4 && one==0)  bfw.write('D');
            else    bfw.write('E');
            bfw.newLine();
        }
        bfw.close();
    }
}