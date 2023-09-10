public class Solution {
    public int countOrders(int n) {
        int modulo = 1_000_000_007;
        long totalPermutations = 1;
        int countOfDivisionsBy2 = n;
        for (int i = 1; i <= n * 2; i++) {
            int multiplier = i;
            while (multiplier % 2 == 0 && countOfDivisionsBy2 >0){
                multiplier /= 2;
                countOfDivisionsBy2--;
            }
            totalPermutations = (totalPermutations * multiplier) % modulo;

        }
        return (int)(totalPermutations % modulo);
    }


}
