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

  public int[] FindNumsAppearOnce (int[] nums) {
        // write code here
        int[] ans = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for(int n:nums){
            map.put(n,1+map.getOrDefault(n,0));
        }
        int index = 0;
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue().equals(1)){
                ans[index++] = entry.getKey();
                if(index==2){
                    break;
                }
            }
        }
        if(ans[0]>ans[1]){
            int tmp = ans[0];
            ans[0] = ans[1];
            ans[1] = tmp;
        }
        return ans;
    }

  public static void main(String[] args) { Main main = new Main(); }
}
