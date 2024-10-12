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


    public TreeNode mergeTrees (TreeNode t1, TreeNode t2) {
        // write code here
        if(t1==null){
            return t2;
        }
        if(t2==null){
            return t1;
        }
        TreeNode ans = new TreeNode(t1.val+t2.val);
        ans.left = mergeTrees(t1.left,t2.left);
        ans.right = mergeTrees(t1.right,t2.right);
        return ans;
    }
    
    public static void main(String[] args) {
        Main main = new Main();
    }
}
