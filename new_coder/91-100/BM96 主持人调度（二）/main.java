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

  public int minmumNumberOfHost(int n, int[][] startEnd) {
    // write code here
    int[] start = new int[n];
    int[] end = new int[n];
    for (int i = 0; i < n; i++) {
      start[i] = startEnd[i][0];
      end[i] = startEnd[i][1];
    }
    Arrays.sort(start);
    Arrays.sort(end);
    int ans = 1;
    int j = 0;
    for (int i = 1; i < n; i++) {
      if (start[i] >= end[j]) {
        j++;
      } else {
        ans++;
      }
    }
    return ans;
  }

  public static void main(String[] args) { Main main = new Main(); }
}
