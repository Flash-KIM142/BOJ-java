public class boj4673 {

    public static void main(String[] args) {
        boolean[] ary = new boolean[10001];

        for(int i=1; i<=10000; i++){
            int tmp = func(i);
            if(tmp>10000)   continue;
            ary[tmp] = true;
        }

        for(int i=1; i<=10000; i++) {
            if(!ary[i]) System.out.println(i);
        }
    }

    static int func(int gen){
        int res = gen;
        while(gen>0){
            res += gen%10;
            gen /= 10;
        }
        return res;
    }
}
