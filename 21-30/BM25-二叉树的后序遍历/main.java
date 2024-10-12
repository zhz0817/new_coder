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
        public ListNode(int val) {
            this.val = val;
        }
    }

    public void getNums(String s){
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='['){
                sb.append('{');
            }else if(ch==']'){
                sb.append('}');
            }else if(ch=='"'){
                sb.append("'");
            } else{
                sb.append(ch);
            }
        }
        System.out.println(sb.toString());
    }


    private void dfs(TreeNode root,List<Integer> list){
        if(root==null){
            return;
        }
        dfs(root.left,list);
        dfs(root.right,list);
        list.add(root.val);
    }
    public int[] postorderTraversal (TreeNode root) {
        // write code here
        List<Integer> list = new ArrayList<>();
        dfs(root,list);
        int n = list.size();
        int[] ans = new int[n];
        for(int i=0;i<n;i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
    
    public static void main(String[] args) {
        Main main = new Main();
    }
}
