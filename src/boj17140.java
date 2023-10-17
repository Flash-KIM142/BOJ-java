// 2023.10.06 삼성 SW 역량 기출

import java.util.*;

public class boj17140 {

    static int R,C,K;
    static int[][] ary = new int[100][100];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();   R--;
        C = sc.nextInt();   C--;
        K = sc.nextInt();

        for(int i=0; i<3; i++)
            for(int j=0; j<3; j++)
                ary[i][j] = sc.nextInt();

        if(ary[R][C]==K) {
            System.out.println("0");
            return;
        }

        int rLen = 3;
        int cLen = 3;
        int time = 0;

        while(true){

            if(rLen>=cLen){
                int newCLen = -1;

                for(int r=0; r<rLen; r++){
                    Map<Integer, Integer> map = new HashMap<>();

                    for(int c=0; c<cLen; c++){
                        if(ary[r][c]==0)    continue;
                        map.putIfAbsent(ary[r][c], 0);
                        map.put(ary[r][c], map.get(ary[r][c])+1);
                        ary[r][c] = 0;
                    }

                    newCLen = Math.max(newCLen, map.size() * 2);
                    List<Integer> keySet = new ArrayList<>(map.keySet());
                    keySet.sort(new Comparator<Integer>() {
                        @Override
                        public int compare(Integer o1, Integer o2) {
                            if(map.get(o1)==map.get(o2))    return o1 - o2;
                            else return map.get(o1) - map.get(o2);
                        }
                    });

                    int idx = 0;
                    for(Integer i: keySet){
                        if(idx==100)    break;
                        ary[r][idx++] = i;
                        ary[r][idx++] = map.get(i);
                    }
                }

                cLen = newCLen;
            }
            else{
                int newRLen = -1;

                for(int c=0; c<cLen; c++){
                    Map<Integer, Integer> map = new HashMap<>();

                    for(int r=0; r<rLen; r++){
                        if(ary[r][c]==0)    continue;
                        map.putIfAbsent(ary[r][c], 0);
                        map.put(ary[r][c], map.get(ary[r][c])+1);
                        ary[r][c] = 0;
                    }

                    newRLen = Math.max(newRLen, map.size()*2);
                    List<Integer> keySet = new ArrayList<>(map.keySet());
                    keySet.sort(new Comparator<Integer>() {
                        @Override
                        public int compare(Integer o1, Integer o2) {
                            if(map.get(o1)==map.get(o2))    return o1 - o2;
                            else return map.get(o1) - map.get(o2);
                        }
                    });

                    int idx = 0;
                    for(Integer i: keySet){
                        if(idx==100)    break;
                        ary[idx++][c] = i;
                        ary[idx++][c] = map.get(i);
                    }
                }

                rLen = newRLen;
            }

            if(time==100) {
                System.out.println("-1");
                break;
            }
            if(ary[R][C]==K) {
                System.out.println(time+1);
                break;
            }
            time++;
        }
    }
}