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

  Stack<Integer> stack1 = new Stack<>();
  Stack<Integer> stack2 = new Stack<>();
  public void push(int node) {
    stack1.push(node);
    if (stack2.isEmpty() || stack2.peek() > node) {
      stack2.push(node);
    } else {
      stack2.push(stack2.peek());
    }
  }

  public void pop() {
    stack1.pop();
    stack2.pop();
  }

  public int top() { return stack1.peek(); }

  public int min() { return stack2.peek(); }

  public static void main(String[] args) { Main main = new Main(); }
}
