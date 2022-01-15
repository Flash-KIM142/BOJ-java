import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.LinkedList;

public class boj14891 {
    static int k;
    static Wheel[] wheels = new Wheel[4];
    static int[] isRotatable = {0,0,0,0};

    public static void main(String args[]) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        for(int i=0; i<4; i++){
            String input = bfr.readLine();
            wheels[i] = new Wheel(input);
        }

        k = Integer.parseInt(bfr.readLine());
        for(int i=0; i<k; i++){
            stk = new StringTokenizer(bfr.readLine());
            int whichWheel = Integer.parseInt(stk.nextToken());
            int direction = Integer.parseInt(stk.nextToken());
            Rotate(whichWheel, direction);
        }

        bfw.write(String.valueOf(GetSum()));
        bfw.close();
    }

    static class Wheel {
        LinkedList<Integer> teethes = new LinkedList<>();

        Wheel(String input){
            for(int i=0; i<8; i++)
                this.teethes.add(Character.getNumericValue(input.charAt(i)));
        }

        void rotate(int direction){
            if(direction==1){ // 시계 방향으로 돌릴 때
                int last = this.teethes.getLast();
                this.teethes.removeLast();
                this.teethes.addFirst(last);
            }
            else{ // 반시계 방향으로 돌릴 때
                int first = this.teethes.getFirst();
                this.teethes.removeFirst();
                this.teethes.addLast(first);
            }
        }
    }

    static void Rotate(int whichWheel, int direction){
        CheckRotatables(whichWheel-1, direction);
        for(int i=0; i<4; i++){
            if(isRotatable[i]==0)   continue;
            else if(isRotatable[i]==1) wheels[i].rotate(1);
            else if(isRotatable[i]==-1) wheels[i].rotate(-1);
        }
        isRotatable = new int[4];
    }
    
    static void CheckRotatables(int startPoint, int direction){
        isRotatable[startPoint] = direction;
        int left = startPoint-1;    int right = startPoint+1;

        if(left>=0 && isRotatable[left]==0){
            if(wheels[startPoint].teethes.get(6)!=wheels[left].teethes.get(2))
                CheckRotatables(left, direction*-1);
        }
        if(right<4 && isRotatable[right]==0){
            if(wheels[startPoint].teethes.get(2)!=wheels[right].teethes.get(6))
                CheckRotatables(right, direction*-1);
        }
    }

    static int GetSum(){
        int answer = 0;
        if(wheels[0].teethes.get(0)==1) answer += 1;
        if(wheels[1].teethes.get(0)==1) answer += 2;
        if(wheels[2].teethes.get(0)==1) answer += 4;
        if(wheels[3].teethes.get(0)==1) answer += 8;
        return answer;
    }
}