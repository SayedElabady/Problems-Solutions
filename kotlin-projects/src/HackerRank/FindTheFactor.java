package HackerRank;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindTheFactor {

    public static long pthFactor(long n, long p) {
        HashSet<Long> factors = new HashSet<>();
        // Write your code here
        for (long i = 1; i <= Math.sqrt(n); ++i) {
            if (n % i == 0) {
                factors.add(i);
                factors.add(n / i);
            }
        }
        if (factors.size() < p)
            return 0;
        else {
            List<Long> list = new ArrayList<Long>(factors);
            return list.get((int) p-1);
        }

    }

    public static void main(String[] args) {
        pthFactor(10,3);
    }
}

