package HackerRank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class SherlockandAnagrams {
    static int sherlockAndAnagrams(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j + i < s.length(); j++) {
                String first = s.substring(i, j).chars()
                        .sorted()
                        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                        .toString();

                String second = (s.substring(0, i) + s.substring(j + 1)).chars()
                        .sorted()
                        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                        .toString();
                for (int k = 0; k + (j - i) < second.length(); k++) {
                    if (second.substring(k, j - i).equals(first)) ans++;
                }
            }
        }
        return ans;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            System.out.println(result);
        }


        scanner.close();
    }
}
