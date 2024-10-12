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

    public ListNode Merge (ListNode pHead1, ListNode pHead2) {
        // write code here
        ListNode ans = new ListNode(-1);
        ListNode node = ans;
        while (pHead1!=null&&pHead2!=null){
            int value1 = pHead1.val;
            int value2 = pHead2.val;
            if(value1<value2){
                node.next = pHead1;
                pHead1 = pHead1.next;
            }else{
                node.next = pHead2;
                pHead2 = pHead2.next;
            }
            node = node.next;
        }
        if(pHead1!=null){
            node.next = pHead1;
        }
        if(pHead2!=null){
            node.next = pHead2;
        }
        return ans.next;
    }

    public static void main(String[] args) {
        Main main = new Main();
//        main.getNums("[[1,0],[0,1]]");
    }
}
