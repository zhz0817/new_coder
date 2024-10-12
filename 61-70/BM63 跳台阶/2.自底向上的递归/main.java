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

  private int dfs(int n) {
    if (n < 0) {
      return 0;
    }
    if (n == 0) {
      return 1;
    }
    int ans = 0;
    for (int i = 1; i <= 2; i++) {
      ans += dfs(n - i);
    }
    return ans;
  }
  public int jumpFloor(int number) {
    // write code here
    return dfs(number);
  }

  public static void main(String[] args) { Main main = new Main(); }
}
