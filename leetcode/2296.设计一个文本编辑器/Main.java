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

    class TextEditor {
        private StringBuffer left, right;
        public TextEditor() {
            left = new StringBuffer();
            right = new StringBuffer();
        }

        public void addText(String text) {
            left.append(text);
        }

        public int deleteText(int k) {
            k = Math.min(k, left.length()); // 防止索引越界
            left.setLength(left.length()
                - k); // 重置长度为left.length()-k,之前的长度是left.length()，意思是删除
            // 后k个元素
            return k;
        }

        public String cursorLeft(int k) {
            while (k > 0 && !left.isEmpty()) {
                k--;
                right.append(
                    left.charAt(left.length() - 1)); // 左侧的元素加入右侧
                left.setLength(left.length() - 1); // 删除最后一个元素
            }
            return text();
        }

        public String cursorRight(int k) {
            while (k > 0 && !right.isEmpty()) {
                k--;
                left.append(right.charAt(right.length() - 1));
                right.setLength(right.length() - 1);
            }
            return text();
        }

        private String text() {
            int k = Math.min(10, left.length());
            return left.substring(left.length()
                - k); // substring只有一个参数代表子串的起点，终点是原串最后一个字符
        }
    }

    /**
     * Your TextEditor object will be instantiated and called as such:
     * TextEditor obj = new TextEditor();
     * obj.addText(text);
     * int param_2 = obj.deleteText(k);
     * String param_3 = obj.cursorLeft(k);
     * String param_4 = obj.cursorRight(k);
     */
    + public static void main(String[] args) {
        Main main = new Main();
        int[][] grid = new int[][] {{1, 2}, {3, 4}};
        var ans = main.maxSum(grid, new int[] {1, 2}, 2);
        System.out.println(ans);
        //        var ans = main.jumpFloor(10);
    }
}
