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

  public String LCS(String str1, String str2) {
    // write code here
    int n = str1.length();
    int m = str2.length();
    int[][] dp = new int[n + 1][m + 1];
    int index = -1;
    int length = 0;
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        char ch1 = str1.charAt(i - 1);
        char ch2 = str2.charAt(j - 1);
        if (ch1 == ch2) {
          dp[i][j] = 1 + dp[i - 1][j - 1];
          if (dp[i][j] > length) {
            length = dp[i][j];
            index = i;
          }
        } else {
          dp[i][j] = 0;
        }
      }
    }
    if (index == -1) {
      return "";
    }
    return str1.substring(index - length, index);
  }

  public static void main(String[] args) { Main main = new Main(); }
}
