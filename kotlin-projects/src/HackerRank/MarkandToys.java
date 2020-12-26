package HackerRank;

import java.util.Arrays;

public class MarkandToys {
    static int maximumToys(int[] prices, int k) {

        Arrays.sort(prices);
        int ans = 0;
        for (int toyPrice : prices) {
            if (k > toyPrice)
                k -= toyPrice;
            else
                break;
            ans++;
        }
        return ans;
    }
}
