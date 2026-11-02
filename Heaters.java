
import java.util.*;

class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);

        int ans = 0;

        for (int house : houses) {
            int index = Arrays.binarySearch(heaters, house);

            if (index >= 0) {
                continue;
            }

            index = -index - 1;

            int left = index > 0 ? house - heaters[index - 1] : Integer.MAX_VALUE;
            int right = index < heaters.length ? heaters[index] - house : Integer.MAX_VALUE;

            ans = Math.max(ans, Math.min(left, right));
        }

        return ans;
    }
}
