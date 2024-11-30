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


    TreeNode head = null;
    TreeNode cur = null;
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree==null)
            return null;
        Convert(pRootOfTree.left);
        if(head==null){
            head = pRootOfTree;
            cur = pRootOfTree;
        }
        else{
            cur.right = pRootOfTree;
            pRootOfTree.left = cur;
            cur = cur.right;
        }
        Convert(pRootOfTree.right);
        return head;
    }
    
    public static void main(String[] args) {
        Main main = new Main();
    }
}
