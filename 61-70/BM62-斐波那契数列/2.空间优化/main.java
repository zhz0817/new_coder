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

  public int Fibonacci(int n) {
    // write code here
    if (n <= 2) {
      return 1;
    }
    int value1 = 1;
    int value2 = 1;
    int ans = 0;
    while (n-- > 2) {
      ans = value1 + value2;
      value1 = value2;
      value2 = ans;
    }
    return ans;
  }

  public static void main(String[] args) { Main main = new Main(); }
}
