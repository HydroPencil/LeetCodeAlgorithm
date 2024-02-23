class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Queue<Integer[]> q = new LinkedList<>();
        HashMap<Integer, List<Integer[]>> flightList = new HashMap<>();
        int[] ans = new int[n];
        Arrays.fill(ans, Integer.MAX_VALUE);
        int stops = 0;
        Integer[] depart = {src, 0};
        q.add(depart);

        for (int[] f : flights) {
            List<Integer[]> in = new LinkedList<>();
            in.add(new Integer[]{f[1], f[2]});
            if (flightList.containsKey(f[0])) {
                in.addAll(flightList.get(f[0]));
            }
            flightList.put(f[0], in);
        }

        while (stops <= k && !q.isEmpty()) {
            stops++;
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Integer[] flight = q.remove();
                if (!flightList.containsKey(flight[0])) continue;

                List<Integer[]> next = flightList.get(flight[0]);
                for (Integer[] newFlight : next) {
                    int price = newFlight[1] + flight[1];
                    if (ans[dst] > price) {
                        if (newFlight[0] == dst) {
                            ans[dst] = price;
                            continue;
                        }
                        if (ans[newFlight[0]] > price) {
                            ans[newFlight[0]] = price;
                            q.add(new Integer[]{newFlight[0], price});
                        }
                    }
                }

            }
        }

        if (ans[dst] == Integer.MAX_VALUE) {
            return -1;
        }

        return ans[dst];
    }
}