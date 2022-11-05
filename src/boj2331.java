import java.io.*;
import java.util.*;

public class boj2331 {
    static int answer;
    static Stack<Integer> stack = new Stack<>();
    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(bfr.readLine());
        int a = Integer.parseInt(stk.nextToken());
        int p = Integer.parseInt(stk.nextToken());

        set.add(a);
        stack.add(a);

        dfs(a, p);
        System.out.println(answer);
    }

    static void dfs(int a, int p){
        double n = 0;
        while(a>0){
            int cur = a%10;
            n += Math.pow(cur,p);
            a /= 10;
        }

        if(set.contains((int) n)){ // 이미 갖고있으면 끝
            while(stack.peek()!=(int) n){
                stack.pop();
            }

            answer = stack.size()-1;
        }
        else{
            stack.add((int) n);
            set.add((int) n);
            dfs((int) n, p);
        }
    }
}
