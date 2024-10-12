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

  public String trans(String s, int n) {
    // write code here
    Map<Character, Character> map = new HashMap<>();
    map.put(' ', ' ');
    for (int i = 0; i < 26; i++) {
      map.put((char)('a' + i), (char)('A' + i));
      map.put((char)('A' + i), (char)('a' + i));
    }
    StringBuffer sb = new StringBuffer();
    StringBuffer tmp = new StringBuffer();
    for (int i = s.length() - 1; i >= 0; i--) {
      char ch = s.charAt(i);
      if (ch == ' ') {
        tmp.reverse();
        sb.append(tmp);
        sb.append(' ');
        tmp.delete(0, tmp.length());
      } else {
        tmp.append(map.get(ch));
      }
    }
    tmp.reverse();
    sb.append(tmp);
    return sb.toString();
  }

  public static void main(String[] args) { Main main = new Main(); }
}
