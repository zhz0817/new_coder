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

  public int rob(int[] nums) {
    // write code here
    int n = nums.length;
    int[] dp = new int[n + 1];
    dp[1] = nums[0];
    for (int i = 2; i <= n; i++) {
      dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
    }
    return dp[n];
  }

  public static void main(String[] args) { Main main = new Main(); }
}
