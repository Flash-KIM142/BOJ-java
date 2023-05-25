import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class boj2512 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        int n = sc.nextInt();
        int[] ary = new int[n];

        int initSum = 0;
        for(int i=0; i<n; i++){
            ary[i] = sc.nextInt();
            initSum += ary[i];
        }
        int m = sc.nextInt();

        Arrays.sort(ary);

        if(initSum<=m){
            System.out.println(ary[n-1]);
        }
        else{
            int l = 0;
            int r = ary[n-1];
            int mid = 0;

            while(l<=r){
                mid = (l+r)/2;

                long sum = 0;
                for(int i=0; i<n; i++){
                    if(ary[i]>=mid) sum += mid;
                    else    sum += ary[i];
                }

                if(sum<=m)  l = mid + 1;
                else    r = mid - 1;
            }

            System.out.println(r);
        }
    }
}