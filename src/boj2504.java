/* 2023.05.25 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj2504 {

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        String input = bfr.readLine();

        Stack<Character> stk = new Stack<>();
        int result = 0;
        int tmp = 1;

        L1: for(int i=0; i<input.length(); i++){
            char c = input.charAt(i);

            switch(c){
                case '(':
                    stk.add('(');
                    tmp *= 2;
                    break;

                case '[':
                    stk.add('[');
                    tmp *= 3;
                    break;

                case ')':
                    if(stk.isEmpty() || stk.peek()!='('){
                        result = 0;
                        break L1;
                    }
                    else{
                        if(input.charAt(i-1)=='(')  result += tmp;
                        stk.pop();
                        tmp /= 2;
                    }
                    break;

                case ']':
                    if(stk.isEmpty() || stk.peek()!='['){
                        result = 0;
                        break L1;
                    }
                    else{
                        if(input.charAt(i-1)=='[')  result += tmp;
                        stk.pop();
                        tmp /= 3;
                    }
                    break;
            }
        }

        if(!stk.isEmpty()) System.out.println(0);
        else System.out.println(result);
    }
}