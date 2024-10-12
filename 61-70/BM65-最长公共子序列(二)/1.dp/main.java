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

  public String LCS(String s1, String s2) {
    // write code here
    if (s1.length() == 0 || s2.length() == 0) {
      return "-1";
    }
    int[][] dp = new int[s1.length() + 1][s2.length() + 1];
    for (int i = 1; i <= s1.length(); i++) {
      for (int j = 1; j <= s2.length(); j++) {
        dp[i][j] = (s1.charAt(i - 1) == s2.charAt(j - 1))
                       ? dp[i - 1][j - 1] + 1
                       : Math.max(dp[i][j - 1], dp[i - 1][j]);
      }
    }
    StringBuffer sb = new StringBuffer();
    for (int i = s1.length(), j = s2.length(); dp[i][j] >= 1;) {
      if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
        sb.append(s1.charAt(i - 1));
        i--;
        j--;
      } else if (dp[i - 1][j] >= dp[i][j - 1]) {
        i--;
      } else {
        j--;
      }
    }
    if (sb.length() == 0) {
      return "-1";
    }
    sb.reverse();
    return sb.toString();
  }

  public static void main(String[] args) { Main main = new Main(); }
}
