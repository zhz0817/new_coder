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


    private int dfs(TreeNode root){
        if(root==null){
            return 0;
        }
        int ans = 0;
        ans = Math.max(dfs(root.left),dfs(root.right))+1;
        return ans;
    }
    public int maxDepth (TreeNode root) {
        // write code here
        return dfs(root);
    }
    
    public static void main(String[] args) {
        Main main = new Main();
    }
}
