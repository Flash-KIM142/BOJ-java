// sort. 2023.07.20

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class boj11728 {

    static int n,m;
    static int[] a,b,c;

    public static void main(String[] args) throws IOException {
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        a = new int[n];
        b = new int[m];
        c = new int[n + m];

        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        for (int i = 0; i < m; i++)
            b[i] = sc.nextInt();

        merge_sort();

        for(int i=0; i<n+m; i++)
            bfw.write(c[i] + " ");
        bfw.flush();
        bfw.close();
    }

    static void merge_sort(){
        int aIdx = 0, bIdx = 0;

        for(int i=0; i<n+m; i++){
            if(aIdx==n) c[i] = b[bIdx++];
            else if(bIdx==m)    c[i] = a[aIdx++];
            else if(a[aIdx]<=b[bIdx])   c[i] = a[aIdx++];
            else    c[i] = b[bIdx++];
        }
    }
}