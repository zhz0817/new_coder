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

  public int uniquePaths(int m, int n) {
    // write code here
    int[][] dp = new int[m + 1][n + 1];
    for (int i = 1; i <= m; i++) {
      dp[i][1] = 1;
    }
    for (int i = 1; i <= n; i++) {
      dp[1][i] = 1;
    }
    for (int i = 2; i <= m; i++) {
      for (int j = 2; j <= n; j++) {
        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
      }
    }
    return dp[m][n];
  }

  public static void main(String[] args) { Main main = new Main(); }
}
