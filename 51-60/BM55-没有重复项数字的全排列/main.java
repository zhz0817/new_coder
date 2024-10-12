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

  ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    int n;

    private void dfs(int[] num,boolean[] isVisited,ArrayList<Integer> list){
        if(list.size()==num.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<n;i++){
            if(!isVisited[i]){
                isVisited[i] = true;
                list.add(num[i]);
                dfs(num,isVisited,list);
                isVisited[i] = false;
                list.remove(list.size()-1);
            }
        }
    }
    public ArrayList<ArrayList<Integer>> permute (int[] num) {
        // write code here
        n = num.length;
        boolean[] isVisited = new boolean[n];
        dfs(num,isVisited,new ArrayList<>());
        return ans;
    }

  public static void main(String[] args) { Main main = new Main(); }
}
