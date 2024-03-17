class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ls = new LinkedList<>();
        int lastadd = 0;
        boolean check = true;

        if (intervals.length == 0) return new int[][]{newInterval};

        for (int i = 0; i < intervals.length; i++) {
            if (
                    intervals[i][0] >= newInterval[0] && intervals[i][0] <= newInterval[1] ||
                            intervals[i][1] >= newInterval[0] && intervals[i][1] <= newInterval[1] ||
                            newInterval[0] >= intervals[i][0] && newInterval[0] <= intervals[i][1] ||
                            newInterval[1] >= intervals[i][0] && newInterval[1] <= intervals[i][1]
            ) {
                newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
                newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
                continue;
            }
            if (check && intervals[i][0] > newInterval[1]) {
                ls.add(newInterval);
                check = false;
            }
            ls.add(intervals[i]);
            lastadd = intervals[i][1];
        }

        if (lastadd < newInterval[0] || ls.isEmpty()) ls.add(newInterval);

        int[][] ans = ls.toArray(new int[ls.size()][2]);

        return ans;
    }
}