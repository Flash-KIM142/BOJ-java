import java.util.*;
import java.io.*;

public class boj2980 {
    public static void main(String args[]) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(bfr.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int l = Integer.parseInt(stk.nextToken());
        Light[] lights = new Light[n+1];
        for(int i=0; i<n; i++){
            stk = new StringTokenizer(bfr.readLine());
            int pos = Integer.parseInt(stk.nextToken());
            int red = Integer.parseInt(stk.nextToken());
            int green = Integer.parseInt(stk.nextToken());
            lights[i] = new Light(pos, red, green);
        }

        int curTime = 0;
        for(int i=0; i<n; i++){
            if(i==0){ // 첫 신호를 만날 때
                curTime += lights[i].position;
            }
            else{ // 두 번째부터는 이전 위치로부터 증가한 만큼만 시간 추가
                curTime += (lights[i].position - lights[i-1].position);
            }

            int terms = curTime / (lights[i].red + lights[i].green); // 몇 텀째인지
            int tmpTime = curTime - (terms * (lights[i].red + lights[i].green)); // 그만큼의 시간을 빼주자

            if(tmpTime<lights[i].red) // 만약 빨간불을 만나 대기해야한다면
                curTime += (lights[i].red - tmpTime); // 요만큼 대기해야함
            else // 초록불이면 그냥 지나가면 됨
                continue;
        }
        curTime += (l - lights[n-1].position);

        bfw.write(String.valueOf(curTime));
        bfw.close();
    }

    static class Light{
        int position;
        int red;
        int green;
        public Light(int position, int red, int green){
            this.position = position;
            this.red = red;
            this.green = green;
        }
    }
}