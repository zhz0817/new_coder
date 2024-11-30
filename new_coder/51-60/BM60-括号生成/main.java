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

  ArrayList<String> ans = new ArrayList<>();
    Stack<Character> stack = new Stack<>();
    private void dfs(int n,StringBuffer sb){
        if(n==0){
            ans.add(sb.toString());
            return;
        }
        if(stack.isEmpty()){
            stack.push('(');
            sb.append('(');
            dfs(n-1,sb);
            sb.deleteCharAt(sb.length()-1);
            stack.pop();
        }else{
            {
                if(stack.size()<=n-1){
                    stack.push('(');
                    sb.append('(');
                    dfs(n-1,sb);
                    sb.deleteCharAt(sb.length()-1);
                    stack.pop();
                }
            }
            {
                stack.pop();
                sb.append(')');
                dfs(n-1,sb);
                sb.deleteCharAt(sb.length()-1);
                stack.push('(');
            }
        }
    }

  public static void main(String[] args) { Main main = new Main(); }
}
