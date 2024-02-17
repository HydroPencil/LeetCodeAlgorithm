class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> ladderPoint = new PriorityQueue<>();

        for (int i = 0; i < heights.length - 1; i++) {
            int movePoint = 0;
            if (heights[i] > heights[i + 1]) {
                continue;
            }

            movePoint = heights[i + 1] - heights[i];
            if (ladderPoint.size() < ladders) {
                ladderPoint.add(movePoint);
                continue;
            }

            if (!ladderPoint.isEmpty() && ladderPoint.peek() < movePoint) {
                bricks -= ladderPoint.poll();
                ladderPoint.add(movePoint);
            } else {
                bricks -= movePoint;
            }

            if (bricks < 0) {
                return i;
            }
        }

        return heights.length - 1;
    }
}