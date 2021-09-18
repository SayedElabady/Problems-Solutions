package HackerRank;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FrequencyQueries {
    static List<Integer> freqQuery(int[][] queries) {
        Map<Integer, Integer> valuesMap = new HashMap<>();
        int[] occurrences = new int[1000009];
        List<Integer> answer = new ArrayList<>();
        for (int[] currentQuery : queries) {
            int operation = currentQuery[0];
            int operand = currentQuery[1];
            if (operation == 1) {
                int currentValue = valuesMap.getOrDefault(operand, -1);
                if (currentValue == -1) {
                    valuesMap.put(operand, 1);
                    occurrences[1]++;
                } else {
                    valuesMap.replace(operand, currentValue + 1);
                    occurrences[currentValue + 1]++;
                    occurrences[currentValue]--;
                }
            } else if (operation == 2) {
                int currentValue = valuesMap.getOrDefault(operand, -1);
                if (currentValue > 0) {
                    valuesMap.replace(operand, currentValue - 1);
                    occurrences[currentValue]--;
                    if(currentValue >1)
                        occurrences[currentValue-1]++;

                }
            } else {
                if (occurrences[operand] > 0) answer.add(1);
                else answer.add(0);
            }
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in))) {

            int q = Integer.parseInt(bufferedReader.readLine().trim());
            int[][] queries = new int[q][2];

            for (int i = 0; i < q; i++) {
                String[] query = bufferedReader.readLine().split(" ");
                queries[i][0] = Integer.parseInt(query[0]);
                queries[i][1] = Integer.parseInt(query[1]);
            }

            List<Integer> ans = freqQuery(queries);

            try (BufferedWriter bufferedWriter = new BufferedWriter(
                    new FileWriter(System.getenv("OUTPUT_PATH")))) {

                bufferedWriter.write(ans.stream().map(Object::toString)
                        .collect(joining("\n")) + "\n");
            }
        }
    }
}
