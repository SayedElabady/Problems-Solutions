package HackerRank;

import java.util.Arrays;

public class MaxArraySum {
    static int max = Integer.MIN_VALUE;

    static int maxSubsetSum(int[] arr) {
        if (arr.length == 0) return Integer.MIN_VALUE;
        if (arr.length == 1) return arr[0];
        for (int i = 2; i < arr.length; i++) {
            arr[i] = Math.max(arr[i], Math.max(arr[i - 1], arr[i] + arr[i - 2]));
        }


        return arr[arr.length - 1];
    }

    public static void main(String[] args) {
        int[] arr = {3, 7, 4, 6, 5};
        maxSubsetSum(arr);
    }
}
