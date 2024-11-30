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

  public int maxArea(int[] height) {
    // write code here
    int ans = 0;
    int left = 0;
    int right = height.length - 1;
    while (left < right) {
      int a = right - left;
      int b = Math.min(height[left], height[right]);
      ans = Math.max(ans, a * b);
      if (height[left] < height[right]) {
        left++;
      } else {
        right--;
      }
    }
    return ans;
  }

  public static void main(String[] args) { Main main = new Main(); }
}
