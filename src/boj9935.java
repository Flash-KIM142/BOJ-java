// 2023.11.03 문자열

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj9935 {

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        String input = bfr.readLine();
        String bomb = bfr.readLine();

        int inputLen = input.length();
        int bomb_len = bomb.length();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < inputLen; i++) {
            sb.append(input.charAt(i));

            if (sb.length() >= bomb_len) {
                int cnt = 0;
                for (int j = sb.length() - bomb_len, k = 0; j < sb.length(); j++, k++) {
                    if (sb.charAt(j) == bomb.charAt(k)) {
                        cnt++;
                    } else {
                        break;
                    }
                }

                if (cnt == bomb_len) {
                    sb.delete(sb.length() - bomb_len, sb.length());
                }
            }
        }

        String result = sb.toString();
        if (result.isEmpty()) {
            System.out.println("FRULA");
        } else {
            System.out.println(result);
        }
    }
}