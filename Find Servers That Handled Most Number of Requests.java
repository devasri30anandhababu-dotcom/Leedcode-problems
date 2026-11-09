import java.util.*;

class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        PriorityQueue<Integer> free = new PriorityQueue<>();
        PriorityQueue<long[]> busy = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        for (int i = 0; i < k; i++) free.add(i);

        int[] cnt = new int[k];
        int n = arrival.length;

        for (int i = 0; i < n; i++) {
            while (!busy.isEmpty() && busy.peek()[0] <= arrival[i]) {
                int id = (int) busy.poll()[1];
                free.add(i + Math.floorMod(id - i, k));
            }
            if (free.isEmpty()) continue;

            int id = free.poll() % k;
            cnt[id]++;
            busy.add(new long[]{(long) arrival[i] + load[i], id});
        }

        int mx = 0;
        for (int c : cnt) mx = Math.max(mx, c);

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (cnt[i] == mx) res.add(i);
        }
        return res;
    }
}
