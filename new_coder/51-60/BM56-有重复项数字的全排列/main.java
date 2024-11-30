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

  ArrayList<ArrayList<Integer>> ans;
    Set<String> set = new HashSet<>();
    public void dfs(int count,int[] nums,boolean[] isVisited,ArrayList<Integer> list){
        if(count==nums.length){
            StringBuffer sb = new StringBuffer();
            for(Integer integer:list){
                sb.append(integer);
            }
            if(set.contains(sb.toString())){
                return;
            }
            set.add(sb.toString());
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!isVisited[i]){
                isVisited[i] = true;
                list.add(nums[i]);
                dfs(count+1,nums,isVisited,list);
                isVisited[i] = false;
                list.remove(list.size()-1);
            }
        }
    }
    public ArrayList<ArrayList<Integer>> permuteUnique (int[] num) {
        // write code here
        ans = new ArrayList<>();
        Arrays.sort(num);
        int n = num.length;
        boolean[] isVisited = new boolean[n];
        dfs(0,num,isVisited,new ArrayList<>());
        return ans;
    }

  public static void main(String[] args) { Main main = new Main(); }
}
