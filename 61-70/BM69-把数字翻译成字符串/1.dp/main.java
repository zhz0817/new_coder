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

  public int solve(String nums) {
    // write code here
    int n = nums.length();
    if (n == 0 || nums.charAt(0) == '0') {
      return 0;
    }
    int[] dp = new int[n + 1];
    dp[0] = 1;
    dp[1] = 1;
    for (int i = 2; i <= n; i++) {
      if (nums.charAt(i - 1) != '0') {
        dp[i] = dp[i - 1];
      }
      int value = Integer.parseInt(nums.substring(i - 2, i));
      if (value >= 10 && value <= 26) {
        dp[i] += dp[i - 2];
      }
    }
    return dp[n];
  }

  public static void main(String[] args) { Main main = new Main(); }
}
