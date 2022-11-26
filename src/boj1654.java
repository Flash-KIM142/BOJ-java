import java.util.*;

public class boj1654{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        int N = sc.nextInt();

        long[] mine = new long[K];
        for(int i=0; i<K; i++)
            mine[i] = sc.nextInt();

        Arrays.sort(mine);
        long l = 1, r = mine[K-1];
        long mid = 0;

        while(l<=r){
            mid = (l+r)/2;

            int total = 0;
            for(int i=0; i<K; i++){
                total += mine[i]/mid;
            }

            if(total<N){
                r = mid - 1;
            }
            else{
                l = mid + 1;
            }
        }

        System.out.println(r); // Upper Bound !!
    }
}