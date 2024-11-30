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

  Stack<Integer> stack1 = new Stack<Integer>();
  Stack<Integer> stack2 = new Stack<Integer>();

  public void push(int node) { stack1.push(node); }

  public int pop() {
    if (!stack2.isEmpty()) {
      return stack2.pop();
    }
    while (!stack1.isEmpty()) {
      stack2.push(stack1.pop());
    }
    return stack2.pop();
  }

  public static void main(String[] args) { Main main = new Main(); }
}
