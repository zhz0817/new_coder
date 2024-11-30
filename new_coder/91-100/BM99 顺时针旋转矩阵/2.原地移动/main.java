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

  public int[][] rotateMatrix(int[][] mat, int n) {
    // write code here
    for (int i = 0; i < n; i++) {
      for (int j = i; j < n; j++) {
        int tmp = mat[i][j];
        mat[i][j] = mat[j][i];
        mat[j][i] = tmp;
      }
    }
    for (int i = 0; i < n; i++) {
      int left = 0;
      int right = n - 1;
      while (left < right) {
        int tmp = mat[i][left];
        mat[i][left] = mat[i][right];
        mat[i][right] = tmp;
        left++;
        right--;
      }
    }
    return mat;
  }

  public static void main(String[] args) { Main main = new Main(); }
}
