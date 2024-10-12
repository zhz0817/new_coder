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

  public int minMoney(int[] arr, int aim) {
    // write code here
    if (aim == 0) {
      return 0;
    }
    if (arr.length == 0) {
      return -1;
    }
    int[] dp = new int[aim + 1];
    Arrays.fill(dp, Integer.MAX_VALUE / 4);
    dp[0] = 0;
    for (int i = 1; i <= aim; i++) {
      for (int j = 0; j < arr.length; j++) {
        if (i >= arr[j]) {
          dp[i] = Math.min(dp[i], dp[i - arr[j]] + 1);
        }
      }
    }
    return dp[aim] == Integer.MAX_VALUE / 4 ? -1 : dp[aim];
  }

  public static void main(String[] args) { Main main = new Main(); }
}
