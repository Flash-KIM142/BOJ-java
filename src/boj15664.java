// 2023.10.18 backtracking

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class boj15664 {

    static List<MyIntArray> result = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] ary = new int[N];
        for (int i = 0; i < N; i++) ary[i] = sc.nextInt();
        Arrays.sort(ary);

        int[] bt = new int[M];
        backtracking(ary, bt, 0, 0, M);
        for(MyIntArray a: result){
            a.print();
        }
    }

    public static void backtracking(int[] ary, int[] bt, int start, int depth, int M){
        if(depth==M){
            int[] tmpBt = bt.clone();
            MyIntArray tmp = new MyIntArray(tmpBt);
            if(!result.contains(tmp)) result.add(tmp);

            return;
        }

        for(int i=start; i<ary.length; i++){
            bt[depth] = ary[i];
            backtracking(ary, bt, i+1, depth+1, M);
        }
    }

    static class MyIntArray {
        private int[] data;

        public MyIntArray(int[] data) {
            this.data = data;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            MyIntArray other = (MyIntArray) obj;
            return Arrays.equals(data, other.data);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(data);
        }

        public void print(){
            int len = this.data.length;
            for(int i=0; i<len; i++){
                System.out.print(this.data[i] + " ");
            }
            System.out.println();
        }
    }
}