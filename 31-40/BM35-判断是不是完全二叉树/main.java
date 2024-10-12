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


    public boolean isCompleteTree (TreeNode root) {
        // write code here
        if(root==null){
            return true;
        }
        Queue<TreeNode> queue =new ArrayDeque<>();
        queue.offer(root);
        int flag = 0;
        int count = 0;
        while (!queue.isEmpty()){
            int length = queue.size();
            if(length<(int)Math.pow(2,count)){
                flag++;
                if(flag==2){
                    return false;
                }
            }
            count++;
            boolean tmp = false;
            for(int i=0;i<length;i++){
                TreeNode node = queue.poll();
                if(node.left==null&&node.right!=null){
                    return false;
                }
                if(node.left!=null){
                    if(tmp){
                        return false;
                    }
                    queue.offer(node.left);
                }else{
                    tmp = true;
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }else{
                    tmp = true;
                }
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        Main main = new Main();
    }
}
