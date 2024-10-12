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
    public int dfs(TreeNode root){
        if(root==null||!ans){
            return 0;
        }
        int left = 1+dfs(root.left);
        int right = 1+dfs(root.right);
        if(Math.abs(left-right)>1){
            ans = false;
        }
        return Math.max(left,right);
    }

    public boolean IsBalanced_Solution (TreeNode pRoot) {
        // write code here
        if(pRoot==null){
            return true;
        }
        dfs(pRoot);
        return ans;
    }
    
    public static void main(String[] args) {
        Main main = new Main();
    }
}
