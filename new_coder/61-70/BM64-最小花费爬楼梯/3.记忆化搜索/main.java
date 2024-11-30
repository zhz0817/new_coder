import java.util.*;
public class Main {

  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }

  public static class ListNode {
    int val;
    ListNode next = null;
    public ListNode(int val) { this.val = val; }
  }

  public void getNums(String s) {
    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (ch == '[') {
        sb.append('{');
      } else if (ch == ']') {
        sb.append('}');
      } else if (ch == '"') {
        sb.append("'");
      } else {
        sb.append(ch);
      }
    }
    System.out.println(sb.toString());
  }

  Map<Integer, Integer> map = new HashMap<>();
  private int dfs(int[] nums, int cur) {
    if (cur >= nums.length) {
      return 0;
    }
    if (map.containsKey(cur)) {
      return map.get(cur);
    }
    int ans = nums[cur];
    ans += Math.min(dfs(nums, cur + 1), dfs(nums, cur + 2));
    map.put(cur, ans);
    return ans;
  }
  public int minCostClimbingStairs(int[] cost) {
    // write code here
    int n = cost.length;
    if (n == 1) {
      return cost[0];
    }
    int ans = Integer.MAX_VALUE;
    ans = Math.min(dfs(cost, 0), ans);
    ans = Math.min(dfs(cost, 1), ans);
    return ans;
  }

  public static void main(String[] args) { Main main = new Main(); }
}
