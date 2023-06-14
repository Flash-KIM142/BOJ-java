/* 2023.06.14 */

import java.util.Scanner;

public class boj1629 {

    public static void main(String[] args) {
        long A,B,C;
        Scanner sc = new Scanner(System.in);
        A = sc.nextLong();
        B = sc.nextLong();
        C = sc.nextLong();

        System.out.println(recur(A,B,C));
    }

    static long recur(long A, long B, long C){
        if(B==1)    return A%C;

        long val = recur(A, B/2, C);
        val = val * val % C;
        if(B%2==0)  return val;
        else    return A*val%C;
    }
}