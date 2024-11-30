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

  public ArrayList<Integer> maxInWindows (int[] num, int size) {
        // write code here
        if(size>num.length||size==0){
            return new ArrayList<>();
        }
        ArrayList<Integer> ans = new ArrayList<>();
        int left = 0;
        int right = 0;
        Queue<Integer> queue = new PriorityQueue<>((a,b)->b.compareTo(a));
        while (right<num.length){
            queue.offer(num[right]);
            if(right-left==size-1){
                ans.add(queue.peek());
                int value = num[left];
                queue.remove(value);
                left++;
            }
            right++;
        }
        return ans;
    }

  public static void main(String[] args) { Main main = new Main(); }
}
