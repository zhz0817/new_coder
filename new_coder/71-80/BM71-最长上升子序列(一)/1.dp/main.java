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

  public int LIS(int[] arr) {
    // write code here
    int n = arr.length;
    if (n == 0) {
      return 0;
    }
    int[] dp = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      dp[i] = 1;
      for (int j = 1; j < i; j++) {
        if (arr[i - 1] > arr[j - 1]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
    }
    return Arrays.stream(dp).max().getAsInt();
  }

  public static void main(String[] args) { Main main = new Main(); }
}
