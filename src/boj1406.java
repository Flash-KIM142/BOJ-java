import java.io.*;
import java.util.*;

public class boj1406 {

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = bfr.readLine();
        int M = Integer.parseInt(bfr.readLine());

        Stack<Character> org = new Stack<>();
        Stack<Character> tmp = new Stack<>();
        int len = input.length();
        for (int i = 0; i < len; i++) org.add(input.charAt(i));

        for(int i=0; i<M; i++){
            String cmdStr = bfr.readLine().replace(" ", "");
            char[] cmd = cmdStr.toCharArray();

            switch(cmd[0]){
                case 'P':
                    org.add(cmd[1]);
                    break;

                case 'L':
                    if(!org.isEmpty())  tmp.add(org.pop());
                    break;

                case 'D':
                    if(!tmp.isEmpty()) org.add(tmp.pop());
                    break;

                case 'B':
                    if(!org.isEmpty()) org.pop();
                    break;
            }
        }

        while(!tmp.isEmpty()) org.add(tmp.pop());

        for(Character ch : org) bfw.write(ch);
        bfw.close();
    }
}