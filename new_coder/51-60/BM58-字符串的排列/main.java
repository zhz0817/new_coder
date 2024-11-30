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

  Set<String> set = new HashSet<>();
    public void dfs(char[] chs,StringBuffer sb,boolean[] isVisited){
        if(sb.length()==chs.length){
            set.add(sb.toString());
            return;
        }
        for(int i=0;i<chs.length;i++){
            if(!isVisited[i]){
                isVisited[i] = true;
                sb.append(chs[i]);
                dfs(chs,sb,isVisited);
                sb.deleteCharAt(sb.length()-1);
                isVisited[i] = false;
            }
        }
    }
    public ArrayList<String> Permutation (String str) {
        // write code here
        char[] chs= str.toCharArray();
        boolean[] isVisited = new boolean[chs.length];
        dfs(chs,new StringBuffer(),isVisited);
        return new ArrayList<>(set);
    }

  public static void main(String[] args) { Main main = new Main(); }
}
