class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();

        for (int i : arr) {
            int count = 1;
            if (m.containsKey(i)) {
                count += m.get(i);
            }
            m.put(i, count);
        }

        List<Integer> keys = new ArrayList<>(m.keySet());
        Collections.sort(keys, (v1, v2) -> (m.get(v1).compareTo(m.get(v2))));

        for (int i : keys) {
            int j = m.get(i);
            if (k >= j) {
                k -= j;
                m.remove(i);
            }

        }

        return m.size();
    }
}