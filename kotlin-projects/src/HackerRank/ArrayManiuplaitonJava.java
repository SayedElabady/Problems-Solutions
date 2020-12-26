package HackerRank;

public class ArrayManiuplaitonJava {
    static long arrayManipulation(int n, int[][] queries) {
        long arr[] = new long[n + 1];
        for (int i = 0; i < queries.length; ++i) {
            arr[queries[i][0]] += queries[i][2];
            arr[queries[i][1] + 1] -= queries[i][2];
        }
        long max = Long.MIN_VALUE;
        for (int i = 1; i < arr.length; i++) {
            arr[i] += arr[i - 1];
            max = Math.max(max, arr[i]);
        }
        return max;
    }
}
