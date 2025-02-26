import java.util.*;
import java.util.concurrent.*;

public class Main {
    class Fenwick {
        int[] tree;
        int n;
        public Fenwick(int[] nums) {
            this.n = nums.length;
            this.tree = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                add(i, nums[i - 1]);
                int next = lowBit(i) + i;
                if (next <= n) {
                    add(next, tree[i]);
                }
            }
        }

        private int lowBit(int n) {
            return n & -n;
        }

        public void update(int index, int value) {
            for (int i = index; i <= n; i += lowBit(i)) {
                this.tree[i] += value;
            }
        }

        public int query(int index) {
            int ans = 0;
            while (index >= 1) {
                ans += tree[index];
                index -= lowBit(index);
            }
            return ans;
        }

        public void add(int index, int value) {
            this.tree[index] += value;
        }
    }

    class UniondFind {
        int[] root;
        UniondFind(int n) {
            root = new int[n];
            for (int i = 0; i < n; i++) {
                root[i] = i;
            }
        }

        public void union(int x, int y) {
            if (x > y) {
                union(y, x);
            }
            int rootX = find(x);
            int rootY = find(y);
            root[rootY] = rootX;
        }

        public int find(int x) {
            if (x == root[x]) {
                return x;
            }
            root[x] = find(root[x]);
            return root[x];
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        UniondFind uf = new UniondFind(n);
        for (int[] edge : edges) {
            int node1 = edge[0] - 1;
            int node2 = edge[1] - 1;
            if (uf.find(node1) != uf.find(node2)) {
                uf.union(node1, node2);
            } else {
                return edge;
            }
        }
        return null;
    }

    class Pair {
        List<Integer> list;
        int index;

        public Pair(int[] nums, int index) {
            list = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                list.add(nums[i]);
            }
            this.index = index;
        }
    }
    public long maxSum(int[][] grid, int[] limits, int k) {
        for (int i = 0; i < grid.length; i++) {
            Arrays.sort(grid[i]);
        }
        Queue<Pair> queue = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                Integer i1 = o1.list.get(o1.list.size() - 1);
                Integer i2 = o2.list.get(o2.list.size() - 1);
                return i2.compareTo(i1);
            }
        });
        for (int i = 0; i < grid.length; i++) {
            queue.offer(new Pair(grid[i], i));
        }
        long ans = 0;
        while (k > 0 && !queue.isEmpty()) {
            Pair top = queue.poll();
            int index = top.index;
            if (limits[index] == 0) {
                continue;
            }
            limits[index]--;
            ans += top.list.getLast();
            top.list.removeLast();
            if (!top.list.isEmpty()) {
                queue.offer(top);
            }
            k--;
        }
        return ans;
    }

    class BrowserHistory {
        List<String> list; // 存储浏览历史
        int cur;

        int maxVaild;
        public BrowserHistory(String homepage) {
            list = new ArrayList<>();
            list.add(homepage); // 第一个访问主页
            cur = 0; // 当前指针指向的下标
            maxVaild = 0; // 最大合法长度,闭区间
        }

        public void visit(String url) {
            while (list.size() > cur + 1) {
                list.removeLast(); // 删除前进历史
            }
            list.add(url);
            cur = list.size() - 1;
            maxVaild = cur; // 更新maxVaild
        }

        public String back(int steps) {
            if (cur >= steps) {
                cur -= (steps);
            } else {
                cur = 0;
            }
            return list.get(cur);
        }

        public String forward(int steps) {
            if (cur + steps > maxVaild) {
                cur = maxVaild;
            } else {
                cur += steps;
            }
            return list.get(cur);
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        int[][] grid = new int[][] {{1, 2}, {3, 4}};
        var ans = main.maxSum(grid, new int[] {1, 2}, 2);
        System.out.println(ans);
        //        var ans = main.jumpFloor(10);
    }
}
