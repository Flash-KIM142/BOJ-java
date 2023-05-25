import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj10828 {

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bfr.readLine());
        Stack<Integer> stk = new Stack<>();

        for(int i=0; i<N; i++){
            String cmd = bfr.readLine();
            String[] cmdAry = cmd.split(" ");

            switch(cmdAry[0]){
                case "push":
                    stk.add(Integer.parseInt(cmdAry[1]));
                    break;

                case "top":
                    if(stk.isEmpty()) System.out.println(-1);
                    else System.out.println(stk.peek());
                    break;

                case "size":
                    System.out.println(stk.size());
                    break;

                case "empty":
                    if(stk.isEmpty()) System.out.println(1);
                    else System.out.println(0);
                    break;

                case "pop":
                    if(stk.isEmpty()) System.out.println(-1);
                    else System.out.println(stk.pop());
                    break;

                default:
                    break;
            }
        }
    }
}