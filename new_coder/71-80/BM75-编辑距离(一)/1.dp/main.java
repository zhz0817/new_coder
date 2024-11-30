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

  public boolean testString(String s) {
    int length = s.length();
    if (length == 0)
      return false;
    if (length == 1)
      return true;
    if (s.charAt(0) == '0')
      return false;
    return Integer.valueOf(s) <= 255;
  }

  public int editDistance(String str1, String str2) {
    // write code here
    int n = str1.length();
    int m = str2.length();
    int[][] dp = new int[n + 1][m + 1]; // dp[i][j] 代表 word1 到 i 位置转换成
                                        // word2 到 j 位置需要最少步数
    for (int i = 1; i <= n; i++) {
      dp[i][0] = 1 + dp[i - 1][0];
    }
    for (int i = 1; i <= m; i++) {
      dp[0][i] = 1 + dp[0][i - 1];
    }
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1];
        } else {
          dp[i][j] =
              Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1])) +
              1;//dp[i-1][j-1] 表示替换操作，dp[i-1][j] 表示删除操作，dp[i][j-1] 表示插入操作。均是对i而言
        }
      }
    }
    return dp[n][m];
  }

  public static void main(String[] args) { Main main = new Main(); }
}
