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

  public int getLongestPalindrome(String A) {
    // write code here
    int ans = 1;
    int n = A.length();
    for (int i = 0; i < n; i++) {
      for (int j = n - 1; j > i; j--) {
        if (j - i + 1 <= ans) {
          break;
        }
        int l = i;
        int r = j;
        boolean flag = true;
        while (l < r) {
          if (A.charAt(l) != A.charAt(r)) {
            flag = false;
            break;
          }
          l++;
          r--;
        }
        if (flag) {
          ans = Math.max(ans, j - i + 1);
          break;
        }
      }
    }
    return ans;
  }

  public static void main(String[] args) { Main main = new Main(); }
}
