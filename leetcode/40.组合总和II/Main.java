class Solution {
    private void dfs(int[] candidates, int len, int begin, int target, Deque<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < len; i++) {
            if (target - candidates[i] < 0) {
                break;
            }
            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }
            path.addLast(candidates[i]);
            dfs(candidates, len, i + 1, target - candidates[i], path, res);
            path.removeLast();
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int length = candidates.length;
        if(length==0)
            return res;
        Arrays.sort(candidates);
        Deque<Integer> path = new ArrayDeque<>(length);
        dfs(candidates, length, 0, target, path, res);
        return res;
    }
}