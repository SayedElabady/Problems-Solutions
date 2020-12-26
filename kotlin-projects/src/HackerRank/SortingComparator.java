package HackerRank;

import java.util.Comparator;

public class SortingComparator implements Comparator<SortingComparator.Player> {
    // complete this method
    public int compare(Player a, Player b) {

        if (a.score != b.score)
            return b.score - a.score;
        else
            return b.name.compareTo(a.name);
    }

    public class Player {
        public int score;
        public String name;
    }
}
