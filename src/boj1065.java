import java.util.Scanner;

public class boj1065 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int res = 0;
        for(int i=1; i<=N; i++){
            if(isHanSoo(i)) res++;
        }

        System.out.println(res);
    }

    static boolean isHanSoo(int n){
        boolean res = true;
        if(n<100)   return true;

        if(n<1000){
            int a = n % 10;
            n /= 10;
            int b = n%10;
            n /= 10;
            int c = n;

            return a-b == b-c;
        }

        if(n==1000) return false;
        return res;
    }
}
