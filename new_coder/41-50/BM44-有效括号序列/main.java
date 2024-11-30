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

  public boolean isValid (String s) {
        // write code here
        Stack<Character> stack = new Stack<>();
        Map<Character,Character> map = new HashMap<>();
        map.put(')','(');map.put(']','[');map.put('}','{');
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(stack.isEmpty()){
                stack.push(ch);
            }else{
                if(map.containsKey(ch)){
                    if(stack.peek()==map.get(ch)){
                        stack.pop();
                    }else{
                        return false;
                    }
                }else{
                    stack.push(ch);
                }
            }
        }
        return stack.isEmpty();
    }

  public static void main(String[] args) { Main main = new Main(); }
}
