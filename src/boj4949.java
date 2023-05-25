import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj4949 {

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String input = bfr.readLine();
            if(input.equals("."))   break;

            boolean flag = true;
            Stack<Character> stk = new Stack<>();
            int len = input.length();
            for(int i=0; i<len; i++){
                char cur = input.charAt(i);

                switch(cur){
                    case '(': case '[':
                        stk.add(cur);
                        break;

                    case ')':
                        if(!stk.isEmpty() && stk.peek()=='(') stk.pop();
                        else    flag = false;
                        break;

                    case ']':
                        if(!stk.isEmpty() && stk.peek()=='[') stk.pop();
                        else    flag = false;
                        break;

                    default:
                        break;
                }
            }

            if(!stk.isEmpty())  flag = false;

            if(flag) System.out.println("yes");
            else System.out.println("no");
        }
    }
}