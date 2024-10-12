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

  public String longestCommonPrefix(String[] strs) {
    // write code here
    if (strs.length == 0 || strs == null)
      return "";
    int l1 = strs[0].length();
    int l2 = strs.length;
    for (int i = 0; i < l1; i++) {
      char flag = strs[0].charAt(i);
      for (int j = 1; j < l2; j++) {
        if (i == strs[j].length() || flag != strs[j].charAt(i))
          return strs[0].substring(0, i);
      }
    }
    return strs[0];
  }

  public static void main(String[] args) { Main main = new Main(); }
}
