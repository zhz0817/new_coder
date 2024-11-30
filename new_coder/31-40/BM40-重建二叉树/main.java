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


    Map<Integer,Integer> map;

    private TreeNode fun(int[] preOrder, int[] vinOrder,int pl,int pr,int vl,int vr){
        if(pl>pr){
            return null;
        }
        int pRoot = pl;
        int vRoot = map.get(preOrder[pRoot]);
        TreeNode root = new TreeNode(preOrder[pRoot]);
        int sub = vRoot-vl;
        root.left = fun(preOrder,vinOrder,pl+1,pl+sub, vl,vRoot-1);
        root.right = fun(preOrder,vinOrder,pl+sub+1,pr,vRoot+1,vr);
        return root;
    }
    
    public TreeNode reConstructBinaryTree (int[] preOrder, int[] vinOrder) {
        // write code here
        int n = preOrder.length;
        if(n==0){
            return null;
        }
        map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(vinOrder[i],i);
        }
        return fun(preOrder,vinOrder,0,n-1,0,n-1);
    }
    
    public static void main(String[] args) {
        Main main = new Main();
    }
}
