class Solution {
    class Room {
        int n;
        int end;

        Room(int n, int end) {
            this.n = n;
            this.end = end;
        }
    }

    public int mostBooked(int n, int[][] meetings) {
        PriorityQueue<Room> freeRoom = new PriorityQueue<>((o1, o2) -> {
            return o1.n - o2.n;
        });
        PriorityQueue<Room> busyRoom = new PriorityQueue<>((o1, o2) -> {
            if (o1.end == o2.end) {
                return o1.n - o2.n;
            }
            return o1.end - o2.end;
        });


        for (int i = 0; i < n; i++) {
            freeRoom.add(new Room(i, 0));
        }
        
        Arrays.sort(meetings, (o1, o2) -> o1[0] - o2[0]);

        int[] meetingCount = new int[n];
        for (int[] meeting : meetings) {
            Room now;
            while (!busyRoom.isEmpty() && busyRoom.peek().end <= meeting[0]) {
                now = busyRoom.poll();
                freeRoom.add(now);
            }

            if (!freeRoom.isEmpty()) {
                now = freeRoom.poll();
                now.end = meeting[1];
                meetingCount[now.n]++;
                busyRoom.add(now);
            } else {
                now = busyRoom.poll();
                now.end += meeting[1] - meeting[0];
                meetingCount[now.n]++;
                busyRoom.add(now);
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (meetingCount[i] > meetingCount[ans]) {
                ans = i;
            }
        }

        return ans;
    }
}