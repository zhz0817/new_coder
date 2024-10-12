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

    String Serialize(TreeNode root) {
        if(root==null){
            return "";
        }
        StringBuffer sb = new StringBuffer();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int length = queue.size();
            boolean flag = false;
            for(int i=0;i<length;i++){
                TreeNode node = queue.poll();
                if(node.val!=-1){
                    flag = true;
                    sb.append(node.val);
                    sb.append(',');
                }else{
                    sb.append('#');
                    sb.append(',');
                    queue.offer(new TreeNode(-1));
                    queue.offer(new TreeNode(-1));
                    continue;
                }
                if(node.left!=null){
                    queue.offer(node.left);
                }else{
                    queue.offer(new TreeNode(-1));
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }else{
                    queue.offer(new TreeNode(-1));
                }
            }
            if(!flag){
                break;
            }
        }
        return sb.toString();
    }
    TreeNode Deserialize(String str) {
       if(str.isEmpty()){
            return null;
        }
        String[] ss = str.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(ss[0]));
        Map<Integer,TreeNode> map = new HashMap<>();
        map.put(0,root);
        for(int i=0;i<ss.length;i++){
            TreeNode cur = null;
            if(map.containsKey(i)){
                cur = map.get(i);
            }else{
                continue;
            }
            if(2*i+1<ss.length){
                String t = ss[2*i+1];
                if(!t.equals("#")){
                    cur.left = new TreeNode(Integer.parseInt(ss[2*i+1]));
                    map.put(2*i+1,cur.left);
                }
            }
            if(2*i+2<ss.length){
                String t = ss[2*i+2];
                if(!t.equals("#")){
                    cur.right = new TreeNode(Integer.parseInt(ss[2*i+2]));
                    map.put(2*i+2,cur.right);
                }
            }
        }
        return root;
    }

    
    public static void main(String[] args) {
        Main main = new Main();
    }
}
