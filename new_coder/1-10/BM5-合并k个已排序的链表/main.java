import java.util.*;
public class Main {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public class ListNode {
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


    class UnionFind{
        int[] parent;
        int[] rank;
        public UnionFind(int n){
            parent = new int[n];
            rank = new int[n];
            for(int i=0;i<n;i++){
                parent[i]=i;
                rank[i]=1;
            }
        }

        public UnionFind(UnionFind other){
            parent = other.parent;
            rank = other.rank;
        }
        public int find(int index){
            if(parent[index]!=index){
                parent[index] = find(parent[index]);
            }
            return parent[index];
        }
        public void union(int p,int q){
            int a = find(p);
            int b = find(q);
            if(a==b){
                return;
            }
            if(rank[a]>rank[b]){
                union(b,a);
            }else{
                rank[b]+=rank[a];
                parent[a]=b;
            }
        }
    }

    public ListNode mergeKLists (ArrayList<ListNode> lists) {
        // write code here
        Queue<ListNode> queue = new PriorityQueue<>((a,b)->a.val-b.val);
        ListNode ans = new ListNode(-1);
        ListNode node = ans;
        for(ListNode listNode:lists){
            if(listNode!=null){
                queue.offer(listNode);
            }
        }
        while (!queue.isEmpty()){
            ListNode tmp = queue.poll();
            node.next = tmp;
            node = node.next;
            tmp = tmp.next;
            if(tmp!=null){
                queue.offer(tmp);
            }
        }
        return ans.next;
    }

    public static void main(String[] args) {
        Main main = new Main();
//        main.getNums("[[1,0],[0,1]]");
    }
}
