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

  public int[] solve(int n, int m, int[] a) {
    // write code here
    while (m-- > 0) {
      int tmp = a[n - 1];
      for (int i = n - 1; i >= 1; i--) {
        a[i] = a[i - 1];
      }
      a[0] = tmp;
    }
    return a;
  }

  public static void main(String[] args) { Main main = new Main(); }
}
