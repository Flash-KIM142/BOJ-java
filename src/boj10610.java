import java.util.*;
import java.io.*;

public class boj10610 {

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        String nStr = bfr.readLine();
        int len = nStr.length();

        int sum = 0;
        boolean flag = false;
        for(int i=0; i<len; i++){
            char cur = nStr.charAt(i);
            int curNum = cur - '0';
            sum += curNum;
            if(curNum==0)    flag = true;
        }

        if(sum%3 !=0)   flag = false;

        char[] ary = nStr.toCharArray();
        Arrays.sort(ary);
        String res = new StringBuilder(new String(ary)).reverse().toString();

        if(!flag)    System.out.println("-1");
        else    System.out.println(res);
    }
}
