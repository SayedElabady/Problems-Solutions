package CTCI;

import java.util.Stack;

public class Chapter8 {

    public static void main(String[] args) {
        int n = 19;
        Tower[] towers = new Tower[n];
        for (int i= 0; i < 3; i++) {
            towers[i] = new Tower(i);
        }

        for (int i= n - 1; i >= 0; i--) {
            towers[0].add(i);
        }
        towers[0].moveDisks(n, towers[2], towers[1]);
    }

    static class Tower {
        private Stack<Integer> disks;
        private int index;
        public Tower(int i) {
            disks = new Stack<Integer>();
            index = i;
        }

        public int index() {
            return index;
        }
        public void add(int d) {
            if (!disks.isEmpty() && disks.peek() <= d) {
                System.out.println("Error placing disk"+ d);
            } else {
                disks.push(d);
            }
        }
        public void moveTopTo(Tower t) {
            int top= disks.pop();
            t.add(top);
        }
        public void moveDisks(int n, Tower destination, Tower buffer) {
            if (n > 0) {
                moveDisks(n - 1, buffer, destination);
                moveTopTo( destination);
                buffer.moveDisks(n - 1, destination, this);
            }
        }
    }
}
