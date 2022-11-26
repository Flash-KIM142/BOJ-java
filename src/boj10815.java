import java.util.*;

public class boj10815{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] myCard = new int[N];

        for(int i=0; i<N; i++)
            myCard[i] = sc.nextInt();

        int M = sc.nextInt();
        int[] doIHave = new int[M];

        for(int i=0; i<M; i++)
            doIHave[i] = sc.nextInt();

        Arrays.sort(myCard);
        for(int i=0; i<M; i++){
            int tmp = 0;
            if(check(myCard, doIHave[i]))    tmp = 1;
            System.out.print(tmp + " ");
        }
    }

    static boolean check(int[] myCard, int target){
        boolean flag = false;
        int l = 0, r = myCard.length-1;

        while(l<=r){ // 등호도 꼭 들어가야 한다는 점!
            int mid = (l + r)/2;

            if(myCard[mid]<target){
                l = mid + 1;
            }
            else if(myCard[mid]>target){
                r = mid - 1;
            }
            else{
                flag = true;
                break;
            }
        }

        return flag;
    }
}