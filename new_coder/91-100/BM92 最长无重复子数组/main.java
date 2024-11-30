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

  public int maxLength(int[] arr) {
    // write code here
    Set<Integer> set = new HashSet<>();
    int left = 0;
    int right = 0;
    int ans = 0;
    while (right < arr.length) {
      int value = arr[right];
      if (set.contains(value)) {
        ans = Math.max(ans, right - left);
        while (true) {
          if (arr[left] != arr[right]) {
            set.remove(arr[left]);
            left++;
          } else {
            break;
          }
        }
        left++;
      } else {
        set.add(value);
      }
      right++;
    }
    return Math.max(ans, right - left);
  }

  public static void main(String[] args) { Main main = new Main(); }
}
