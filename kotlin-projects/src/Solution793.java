import javafx.util.Pair;

import java.util.*;

public class Solution793 {
    public static void main(String[] args) {
        int[][] array = new int[3][2];
        array[0][0] = 3;
        array[0][1] = 3;
        array[1][0] = 5;
        array[1][1] = -1;
        array[2][0] = -2;
        array[2][1] = 4;
     //   int[][] ans = kClosest(array, 2);
        System.out.println();
    }

    public int[][] kClosest(int[][] points, int K) {
        List<Pair<Double, Integer>> calculatedDistances = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            calculatedDistances.add(new Pair(Math.sqrt((points[i][0] * points[i][0]) + (points[i][1] * points[i][1])), i));
        }
        int counter = 0;
        int[][] answer = new int[K][2];
        calculatedDistances.sort(Comparator.comparing(Pair::getKey));
        for (Pair<Double, Integer> distance : calculatedDistances) {
            if (counter == K) break;
            answer[counter][0] = points[distance.getValue()][0];
            answer[counter++][1] = points[distance.getValue()][1];
        }
        return answer;
    }
}

