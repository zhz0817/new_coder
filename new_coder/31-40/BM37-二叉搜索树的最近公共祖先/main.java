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

    public int lowestCommonAncestor (TreeNode root, int p, int q) {
        // write code here
        if(root.val<p&&root.val<q){
            return lowestCommonAncestor(root.right,p,q);
        }
        if(root.val>p&&root.val>q){
            return lowestCommonAncestor(root.left,p,q);
        }
        if(root.val==p){
            return p;
        }
        if(root.val==q){
            return q;
        }
        return root.val;
    }
    
    public static void main(String[] args) {
        Main main = new Main();
    }
}
