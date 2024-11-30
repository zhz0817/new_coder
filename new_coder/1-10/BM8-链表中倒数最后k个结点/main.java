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

    public ListNode hasCycle(ListNode head) {
        if(head==null)
            return null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null&&fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast)
                return slow;
        }
        return null;
    }

    public ListNode FindKthToTail (ListNode pHead, int k) {
        // write code here
        ListNode fast = pHead;
        ListNode slow = pHead;
        for(int i=0;i<k;i++){
            if(fast==null){
                return null;
            }
            fast = fast.next;
        }
        while(fast!=null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        Main main = new Main();
//        main.getNums("[[1,0],[0,1]]");
    }
}
