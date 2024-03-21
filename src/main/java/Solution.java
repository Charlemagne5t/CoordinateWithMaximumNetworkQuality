import java.util.*;

public class Solution {
    public int[] bestCoordinate(int[][] towers, int radius) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] tower : towers) {
            bfs(tower[0], tower[1], tower[2], radius, map);
        }
        PriorityQueue<Integer> maxHashes = new PriorityQueue<>();
        int max = 0;

        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            System.out.println(e);
            if (e.getValue() == max) {
                maxHashes.offer(e.getKey());

            } else if (e.getValue() > max) {
                max = e.getValue();
                maxHashes.clear();
                maxHashes.offer(e.getKey());
            }

        }
        if (max == 0) {
            return new int[]{0, 0};
        }
        int hash = maxHashes.poll();

        return new int[]{hash / 200, hash % 200};
    }

    void bfs(int x, int y, int quality, int radius, Map<Integer, Integer> map) {

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        int level = 0;
        Set<Integer> vis = new HashSet<>();
        int[][] dest = {{-1, 0}, {-1, 1}, {0, 1}, {1, -1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
        while (!q.isEmpty() && level <= quality) {

            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                if (vis.contains(cur[0] * 200 + cur[1])) {
                    continue;
                }
                vis.add(cur[0] * 200 + cur[1]);
                int curX = cur[0];
                int curY = cur[1];
                int strength = map.getOrDefault(curX * 200 + curY, 0);
                strength += (int) ((double) quality / (1 + distance(x, y, curX, curY)));
                map.put(curX * 200 + curY, strength);
                for (int[] d : dest) {
                    int nextX = d[0] + curX;
                    int nextY = d[1] + curY;
                    double distance = distance(x, y, nextX, nextY);
                    if (radius - distance < 0) {
                        continue;
                    }
                    if (!vis.contains(nextX * 200 + nextY) && (double) quality - distance >= 0) {
                        q.offer(new int[]{nextX, nextY});
                    }
                }


            }
        }
    }

    double distance(int x1, int y1, int x2, int y2) {
        int dx = x2 - x1;
        int dy = y2 - y1;
        return Math.sqrt(dx * dx + dy * dy);
    }


}
