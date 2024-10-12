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

  int ans = Integer.MAX_VALUE;

  private void dfs(int[] nums, int index, int value) {
    if (index == nums.length) {
      ans = Math.min(ans, value);
      return;
    }
    if (index > nums.length) {
      return;
    }
    for (int i = 1; i <= 2; i++) {
      dfs(nums, index + i, value + nums[index]);
    }
  }
  public int minCostClimbingStairs(int[] cost) {
    // write code here
    int n = cost.length;
    if (n == 1) {
      return cost[0];
    }
    dfs(cost, 0, 0);
    dfs(cost, 1, 0);
    return ans;
  }

  public static void main(String[] args) { Main main = new Main(); }
}
