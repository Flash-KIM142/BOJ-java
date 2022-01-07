import java.io.*;

public class boj10798 {
    public static void main(String args[]) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[][] ary = new char[6][16];

        for(int i=0; i<5; i++){ // 입력 받자
            String input = bfr.readLine();
            int length = input.length();
            for(int j=0; j<15; j++){
                if(j<length)
                    ary[i][j] = input.charAt(j);
                else
                    ary[i][j] = 0;
            }
        }

        for(int col=0; col<15; col++){
            for(int row=0; row<5; row++){
                if(ary[row][col]==0) continue;
                bfw.write(ary[row][col]);
            }
        }
        bfw.close();
    }
}