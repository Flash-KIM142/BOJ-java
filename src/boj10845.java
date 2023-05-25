import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj10845 {

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bfr.readLine());
        int[] q = new int[N+1];
        int head = 0;
        int tail = 0;

        for(int i=0; i<N; i++){
            String cmd = bfr.readLine();
            String[] cmdAry = cmd.split(" ");

            switch(cmdAry[0]){
                case "push":
                    q[tail++] = Integer.parseInt(cmdAry[1]);
                    break;

                case "front":
                    if(tail-head==0) System.out.println(-1);
                    else    System.out.println(q[head]);
                    break;

                case "size":
                    System.out.println(tail-head);
                    break;

                case "empty":
                    if(tail-head==0) System.out.println(1);
                    else System.out.println(0);
                    break;

                case "pop":
                    if(head-tail==0) System.out.println(-1);
                    else    System.out.println(q[head++]);
                    break;

                case "back":
                    if(tail-head==0) System.out.println(-1);
                    else    System.out.println(q[tail-1]);
                    break;

                default:
                    break;
            }
        }
    }
}
