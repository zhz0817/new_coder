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

  Map<Character, Integer> map = new HashMap<Character, Integer>() {
    {
      put('-', 1);
      put('+', 1);
      put('*', 2);
    }
  };
  public int solve(String s) {
    // write code here
    if (s.length() == 0) {
      return 0;
    }
    if (s.charAt(0) == '-') {
      s = "0" + s;
    }
    Stack<Integer> nums = new Stack<>();
    Stack<Character> op = new Stack<>();
    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (ch == '(') {
        op.push(ch);
      } else if (ch == ')') {
        if (sb.length() > 0) {
          nums.push(Integer.valueOf(sb.toString()));
          sb.delete(0, sb.length());
        }
        while (!op.isEmpty() && nums.size() >= 2) {
          if (op.peek() == '(') {
            op.pop();
            break;
          }
          int tmp = fun(nums.pop(), nums.pop(), op.pop());
          nums.push(tmp);
        }
      } else {
        if (ch >= '0' && ch <= '9') {
          sb.append(ch);
        } else {
          if (i > 0 && (s.charAt(i - 1) == '(' || s.charAt(i - 1) == '+') ||
              s.charAt(i - 1) == '-') {
            op.push(ch);
            continue;
          }
          if (sb.length() > 0) {
            nums.push(Integer.valueOf(sb.toString()));
            sb.delete(0, sb.length());
          }
          if (!op.isEmpty()) {
            if (op.peek() != '(' && map.get(op.peek()) >= map.get(ch)) {
              nums.push(fun(nums.pop(), nums.pop(), op.pop()));
            }
          }
          op.push(ch);
        }
      }
    }
    if (sb.length() > 0) {
      nums.push(Integer.valueOf(sb.toString()));
      sb.delete(0, sb.length());
    }
    while (!op.isEmpty() && nums.size() >= 2) {
      int tmp = fun(nums.pop(), nums.pop(), op.pop());
      nums.push(tmp);
    }
    return nums.pop();
  }

  public int fun(int a, int b, char ch) {
    if (ch == '+') {
      return a + b;
    } else if (ch == '-') {
      return b - a;
    }
    return a * b;
  }
  public static void main(String[] args) { Main main = new Main(); }
}
