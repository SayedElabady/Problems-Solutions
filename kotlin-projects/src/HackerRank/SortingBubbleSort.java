package HackerRank;



public class SortingBubbleSort {
    static void countSwaps(int[] a) {
        int n = a.length;
        int numOfSwaps= 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                // Swap adjacent elements if they are in decreasing order
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1]=temp;
                    numOfSwaps++;
                }
            }

        }

        System.out.println("Array is sorted in " + numOfSwaps +  "swaps.");
        System.out.println("First Element: " + a[0]);
        System.out.println("Last Element: " + a[n-1]);

    }
}
