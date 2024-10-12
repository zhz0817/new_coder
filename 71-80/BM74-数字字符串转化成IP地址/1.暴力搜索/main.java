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

  public boolean testString(String s) {
    int length = s.length();
    if (length == 0)
      return false;
    if (length == 1)
      return true;
    if (s.charAt(0) == '0')
      return false;
    return Integer.valueOf(s) <= 255;
  }

  public ArrayList<String> restoreIpAddresses(String s) {
    // write code here
    ArrayList<String> res = new ArrayList<>();
    int length = s.length();
    for (int i = 1; i <= length; i++) {
      if (i >= 4)
        break;
      for (int j = i + 1; j <= length; j++) {
        if (j - i >= 4)
          break;
        for (int k = j + 1; k <= length; k++) {
          if (k - j >= 4)
            break;
          if (length - k >= 4)
            continue;
          String s1 = s.substring(0, i);
          String s2 = s.substring(i, j);
          String s3 = s.substring(j, k);
          String s4 = s.substring(k, length);
          if (testString(s1) && testString(s2) && testString(s3) &&
              testString(s4)) {
            res.add(s1 + "." + s2 + "." + s3 + "." + s4);
          }
        }
      }
    }
    return res;
  }

  public static void main(String[] args) { Main main = new Main(); }
}
