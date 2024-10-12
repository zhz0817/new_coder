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


    public TreeNode Mirror (TreeNode pRoot) {
        // write code here
        if(pRoot==null){
            return null;
        }
        TreeNode ans = new TreeNode(pRoot.val);
        ans.left = Mirror(pRoot.right);
        ans.right = Mirror(pRoot.left);
        return ans;
    }
    
    public static void main(String[] args) {
        Main main = new Main();
    }
}
