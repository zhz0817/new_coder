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

    public int lowestCommonAncestor (TreeNode root, int o1, int o2) {
        // write code here
        int[] arr1 = new int[2];
        int[] arr2 = new int[2];
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        List<List<Integer>> list = new ArrayList<>();
        int count = 0;
        int level = 0;
        while (!queue.isEmpty()&&count<2){
            int length = queue.size();
            List<Integer> tmp = new ArrayList<>();
            for(int i=0;i<length;i++){
                TreeNode node = queue.poll();
                if(node.val==o1){
                    arr1[0]=level;
                    arr1[1]=i;
                    count++;
                }
                if(node.val==o2){
                    arr2[0]=level;
                    arr2[1]=i;
                    count++;
                }
                tmp.add(node.val);
                if(count==2){
                    break;
                }
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
            level++;
            list.add(tmp);
        }
        while (arr1[0]!=arr2[0]){
            if(arr1[0]>arr2[0]){
                arr1[0]--;
                arr1[1]/=2;
            }else{
                arr2[0]--;
                arr2[1]/=2;
            }
        }
        while (arr1[1]!=arr2[1]){
            arr1[0]--;
            arr2[0]--;
            arr1[1]/=2;
            arr2[1]/=2;
        }
        return list.get(arr1[0]).get(arr1[1]);
    }
    
    public static void main(String[] args) {
        Main main = new Main();
    }
}
