public class Solution190 {

    public static int reverseBits(Integer n) {
        int ans = 0;
        char[] nums = new char[33];
        int it = 0;
        while (n > 0) {
            nums[it] = (char) (n % 2 + '0');
            n /= 2;
            it++;
        }
        for (; it < 32; it++) nums[it] = '0';
        it--;
        int mul = 0;
        for (; it >= 0; it--) {
            int currentBit = (int) (nums[it] - '0');
            if (currentBit > 0)
                ans += (int) (Math.pow(2, currentBit * mul));
            mul++;
        }
        return ans;
    }
    public static void main(String[] args) {
        reverseBits(-3);
    }
}
