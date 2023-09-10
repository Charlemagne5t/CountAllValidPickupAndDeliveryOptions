import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int countOrders(int n) {
        int modulo = 1_000_000_007;
        int[] array = new int[n * 2 + 1];
        for (int i = 0; i < n * 2 + 1; i++) {
            array[i] = i;
        }
        Map<String, Integer> memo = new HashMap<>();

        boolean[] visited = new boolean[array.length];
        return dfs(n, array, 0, visited, memo);
    }

    private int dfs(int n, int[] array, int count, boolean[] visited, Map<String, Integer> memo) {
        int modulo = 1_000_000_007;
        if (count == n * 2) {
            return 1;
        }
        if(memo.containsKey(Arrays.toString(array) + " " + Arrays.toString(visited) + " " + count)){
            return memo.get(Arrays.toString(array) + " " + Arrays.toString(visited) + " " + count);
        }

        int result = 0;
        for (int i = 1; i < array.length; i++) {
            if (i <= n && array[i] > 0 && !visited[i]) {
                array[i] = -array[i];
                visited[i] = true;
                result = (result + dfs(n, array, count + 1, visited, memo) % modulo) % modulo;
                array[i] = -array[i];
                visited[i] = false;
            } else if (i > n && array[i - n] < 0 && !visited[i]) {
                visited[i] = true;
                result = (result + dfs(n, array, count + 1, visited, memo) % modulo) % modulo;
                visited[i] = false;
            }

        }
        memo.put(Arrays.toString(array) + " " + Arrays.toString(visited) + " " + count, result % modulo);
        return result % modulo;
    }
}
