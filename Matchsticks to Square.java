
import java.util.*;

class Solution {
    public boolean makesquare(int[] matchsticks) {
        long sum = 0;

        for (int x : matchsticks) {
            sum += x;
        }

        if (sum % 4 != 0) {
            return false;
        }

        long target = sum / 4;

        Arrays.sort(matchsticks);

        if (matchsticks[matchsticks.length - 1] > target) {
            return false;
        }

        long[] sides = new long[4];

        return backtrack(matchsticks, matchsticks.length - 1, sides, target);
    }

    private boolean backtrack(int[] arr, int index, long[] sides, long target) {
        if (index < 0) {
            return true;
        }

        for (int i = 0; i < 4; i++) {
            if (sides[i] + arr[index] <= target) {
                sides[i] += arr[index];

                if (backtrack(arr, index - 1, sides, target)) {
                    return true;
                }

                sides[i] -= arr[index];
            }

            if (sides[i] == 0) {
                break;
            }
        }

        return false;
    }
}
