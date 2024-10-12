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


    boolean ans = true;
    long pre = Long.MIN_VALUE;
    public void dfs(TreeNode root){
        if(root==null||!ans){
            return;
        }
        dfs(root.left);
        if(root.val<=pre){
            ans = false;
        }else{
            pre = root.val;
        }
        dfs(root.right);
    }
    public boolean isValidBST (TreeNode root) {
        // write code here
        dfs(root);
        return ans;
    }
    
    public static void main(String[] args) {
        Main main = new Main();
    }
}
