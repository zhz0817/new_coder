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

  public int minNumberDisappeared (int[] nums) {
        // write code here
        Set<Integer> set = new HashSet<>();
        for(int n:nums){
            if(n>0){
                set.add(n);
            }
        }
        for(long i=1;i<=Integer.MAX_VALUE;i++){
            int tmp = (int) i;
            if(!set.contains(tmp)){
                return tmp;
            }
        }
        return 0;
    }

  public static void main(String[] args) { Main main = new Main(); }
}
