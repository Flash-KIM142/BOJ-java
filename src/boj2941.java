import java.io.*;

public class boj2941 {
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        String s = bfr.readLine();

        String[] targets = {"c=","c-","dz=","d-","lj","nj","s=","z="};
        for(String t: targets){
            s = s.replaceAll(t, " ");
        }

        System.out.println("" + s.length());
    }
}