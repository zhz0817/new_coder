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

  public String solve(String s, String t) {
    // write code here
    StringBuffer sb = new StringBuffer();
    int mod = 0;
    int index1 = s.length() - 1;
    int index2 = t.length() - 1;
    while (index1 >= 0 || index2 >= 0 || mod > 0) {
      int value1 = index1 >= 0 ? s.charAt(index1) - '0' : 0;
      int value2 = index2 >= 0 ? t.charAt(index2) - '0' : 0;
      int sum = value1 + value2 + mod;
      if (sum >= 10) {
        mod = 1;
        sb.append(sum % 10);
      } else {
        mod = 0;
        sb.append(sum);
      }
      index1--;
      index2--;
    }
    sb.reverse();
    return sb.toString();
  }

  public static void main(String[] args) { Main main = new Main(); }
}
