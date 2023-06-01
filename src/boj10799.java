/* 2023.05.25 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj10799 {

    public static void main(String[] args) throws IOException {
        int result = 0;
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        String input = bfr.readLine();
        input = input.replaceAll("\\(\\)", "L");

        int len = input.length();
        Stack<Integer> stk = new Stack<>();
        int laserCnt = 0;
        for(int i=0; i<len; i++){
            char cur = input.charAt(i);
            if(stk.isEmpty() && cur=='L')   continue;

            switch (cur){
                case '(':
                    stk.add(laserCnt);
                    break;

                case ')':
                    result += laserCnt - stk.pop() + 1;
                    break;

                case 'L':
                    laserCnt++;
                    break;

                default:
                    break;
            }

            if(stk.isEmpty())   laserCnt = 0;
        }

        System.out.println(result);
    }
}