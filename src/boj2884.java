import java.io.*;
import java.util.*;

public class boj2884 {
    public static void main(String args[]) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(bfr.readLine());
        int hours = Integer.parseInt(stk.nextToken());
        int minutes = Integer.parseInt(stk.nextToken());

        if(minutes-45<0){ // 1. 시간 값이 바뀔 경우
            minutes += 15;
            if(hours == 0)
                hours = 23;
            else
                hours -= 1;
        }
        else{ // 2. 시간 값이 그대로일 경우, 분 값만 바뀌면 됨
            minutes -= 45;
        }
        bfw.write(hours + " " + minutes);
        bfw.close();
    }
}