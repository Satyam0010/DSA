class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        TreeSet<Integer> available = new TreeSet<>();
        PriorityQueue<long[]> busy =
            new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));

        int[] count = new int[k];

        for (int i = 0; i < k; i++) {
            available.add(i);
        }

        for (int i = 0; i < arrival.length; i++) {
            long startTime = arrival[i];
            long endTime = startTime + load[i];

            while (!busy.isEmpty() && busy.peek()[0] <= startTime) {
                available.add((int) busy.poll()[1]);
            }

            if (available.isEmpty()) {
                continue;
            }

            int preferred = i % k;
            Integer server = available.ceiling(preferred);

            if (server == null) {
                server = available.first();
            }

            available.remove(server);

            count[server]++;
            busy.add(new long[]{endTime, server});
        }

        int maxCount = 0;
        for (int c : count) {
            maxCount = Math.max(maxCount, c);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (count[i] == maxCount) {
                result.add(i);
            }
        }

        return result;
    }
}