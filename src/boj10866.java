import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class boj10866 {

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bfr.readLine());
        Deque<Integer> dq = new LinkedList<>();

        for(int i=0; i<N; i++){
            String cmd = bfr.readLine();
            String[] cmdAry = cmd.split(" ");

            switch (cmdAry[0]){
                case "push_front":
                    dq.addFirst(Integer.parseInt(cmdAry[1]));
                    break;

                case "push_back":
                    dq.addLast(Integer.parseInt(cmdAry[1]));
                    break;

                case "pop_front":
                    if(dq.isEmpty()) System.out.println(-1);
                    else System.out.println(dq.pollFirst());
                    break;

                case "pop_back":
                    if(dq.isEmpty()) System.out.println(-1);
                    else System.out.println(dq.pollLast());
                    break;

                case "size":
                    System.out.println(dq.size());
                    break;

                case "empty":
                    if(dq.isEmpty()) System.out.println(1);
                    else System.out.println(0);
                    break;

                case "front":
                    if(dq.isEmpty()) System.out.println(-1);
                    else System.out.println(dq.getFirst());
                    break;

                case "back":
                    if(dq.isEmpty()) System.out.println(-1);
                    else System.out.println(dq.getLast());
                    break;

                default:
                    break;
            }
        }

    }
}