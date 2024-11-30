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

  public int jumpFloor(int number) {
    // write code here
    if (number == 1) {
      return 1;
    }
    int[] dp = new int[number + 1];
    dp[1] = 1;
    dp[2] = 2;
    for (int i = 3; i <= number; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[number];
  }

  public static void main(String[] args) { Main main = new Main(); }
}
