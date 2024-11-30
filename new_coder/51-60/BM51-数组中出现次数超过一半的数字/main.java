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

  public int MoreThanHalfNum_Solution (int[] numbers) {
        // write code here
        int count = 0;
        int ans = 0;
        for(int n:numbers){
            if(count==0){
                ans = n;
                count++;
            }else{
                if(ans!=n){
                    count--;
                }else{
                    count++;
                }
            }
        }
        return ans;
    }

  public static void main(String[] args) { Main main = new Main(); }
}
