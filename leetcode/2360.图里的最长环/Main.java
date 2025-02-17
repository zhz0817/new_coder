class Solution {
    public int longestCycle(int[] edges) {
        int n = edges.length;
        boolean[] isVisited = new boolean[n];
        int ans = -1;
        int[] degree = new int[n];
        for (int i = 0; i < n; i++) {
            if (edges[i] == -1) {
                continue;
            }
            degree[edges[i]]++;
        }
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 0) {
                deque.push(i);
            }
        }
        while (!deque.isEmpty()) {
            int cur = deque.poll();
            int next = edges[cur];
            if (next != -1) {
                degree[next]--;
                if (degree[next] == 0) {
                    deque.push(next);
                }
            }
        } // 这里如果degree[i]大于0，说明节点一定在环里
        for (int i = 0; i < n; i++) {
            if (!isVisited[i] && degree[i] > 0) {
                int cur = i;
                int length = 0;
                while (!isVisited[cur]) {
                    isVisited[cur] = true;
                    length++;
                    cur = edges[cur];
                }
                ans = Math.max(ans, length);
            }
        }
        return ans;
    }
}