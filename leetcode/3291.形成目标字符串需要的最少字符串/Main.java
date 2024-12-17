class Solution {
    class Trie { // 字典树

        Trie[] children;

        Trie() {
            this.isEnd = false;
            children = new Trie[26];
        }

        public void insert(String s) { // 字符串插入字典树
            var node = this;
            for (int i = 0; i < s.length(); i++) {
                int index = s.charAt(i) - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new Trie();
                }
                node = node.children[index];
            }
        }

        public List<Integer> search(String s,
            int pos) { // 以pos为起点下标，搜索并存储s字符串被字典树存储过的长度
            var node = this;
            List<Integer> ans = new ArrayList<>();
            for (int i = pos; i < s.length(); i++) {
                int index = s.charAt(i) - 'a';
                if (node.children[index] == null) {
                    break; // 没有被字典树存储，打破循环
                }
                node = node.children[index];
                ans.add(i - pos + 1); // 存储了i-pos+1个字符
            }
            return ans;
        }
    }

    public int minValidStrings(String[] words, String target) {
        int n = target.length();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        for (int i = 0; i < n; i++) { // 向后搜索的动态规划
            if (dp[i]== Integer.MAX_VALUE) { // 因为是向后搜索，如果还是最大int说明无法到达
                continue;
            }
            List<Integer> res = trie.search(target, i);
            for (Integer len : res) { // 更新dp
                dp[i + len] = Math.min(dp[i + len], dp[i] + 1);
            }
        }
        return dp[n] == Integer.MAX_VALUE ? -1 : dp[n];
    }
}