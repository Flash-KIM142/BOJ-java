import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class boj14499 {
    static int n,m,x,y,k;
    static int[][] map;
    static int[] orders;
    static int[][] moveDirection = { {0,1}, {0,-1}, {-1,0}, {1,0} };

    public static void main(String args[]) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(bfr.readLine());
        n = Integer.parseInt(stk.nextToken()); m = Integer.parseInt(stk.nextToken());
        x = Integer.parseInt(stk.nextToken()); y = Integer.parseInt(stk.nextToken());
        k = Integer.parseInt(stk.nextToken());

        map = new int[n][m];
        for(int i=0; i<n; i++){ // 지도 입력
            stk = new StringTokenizer(bfr.readLine());
            for(int j=0; j<m; j++)
                map[i][j] = Integer.parseInt(stk.nextToken());
        }
        orders = new int[k];
        stk = new StringTokenizer(bfr.readLine());
        for(int i=0; i<k; i++) // 명령 입력
            orders[i] = Integer.parseInt(stk.nextToken());


        Dice dice = new Dice();
        for(int i=0; i<k; i++){
            int whereToMove = orders[i];
            int tmpX = x + moveDirection[whereToMove-1][0];
            int tmpY = y + moveDirection[whereToMove-1][1];

            if(isInRange(tmpX, tmpY)){
                x = tmpX;   y = tmpY;

                switch(whereToMove){
                    case 1:
                        dice.move1();
                        break;
                    case 2:
                        dice.move2();
                        break;
                    case 3:
                        dice.move3();
                        break;
                    case 4:
                        dice.move4();
                        break;
                    default:
                        break;
                }

                if(map[x][y]==0){ // 지도가 0이면
                    map[x][y] = dice.bottom;
                }
                else{ // 지도가 0이 아니면
                    dice.bottom = map[x][y];
                    map[x][y] = 0;
                }

                bfw.write(String.valueOf(dice.top) + "\n");
            }
        }
        bfw.close();
    }

    static class Dice {
        int top, bottom, rear, front, left, right;

        Dice(){
            top = 0; bottom = 0; rear = 0; front = 0; left = 0; right = 0;
        }

        void move1(){ // 1번 굴리기, rear&front 은 그대로
            int beforeTop = top; int beforeBottom = bottom; int beforeLeft = left; int beforeRight = right;
            top = beforeLeft; left = beforeBottom; bottom = beforeRight; right = beforeTop;
        }

        void move2(){ // 2번 굴리기, rear&front 은 그대로
            int beforeTop = top; int beforeBottom = bottom; int beforeLeft = left; int beforeRight = right;
            top = beforeRight; right = beforeBottom; bottom = beforeLeft; left = beforeTop;
        }

        void move3(){ // 3번 굴리기, left&right 는 그대로
            int beforeTop = top; int beforeBottom = bottom; int beforeRear = rear; int beforeFront = front;
            top = beforeFront; front = beforeBottom; bottom = beforeRear; rear = beforeTop;
        }

        void move4(){ // 4번 굴리기, left&right 는 그대로
            int beforeTop = top; int beforeBottom = bottom; int beforeRear = rear; int beforeFront = front;
            top = beforeRear; front = beforeTop; bottom = beforeFront; rear = beforeBottom;
        }
    }

    static Boolean isInRange(int x, int y){
        if(0<=x && x<n && 0<=y && y<m)  return true;
        else    return false;
    }
}