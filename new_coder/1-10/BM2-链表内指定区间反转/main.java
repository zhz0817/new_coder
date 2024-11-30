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

    public ListNode reverseBetween (ListNode head, int m, int n) {
        // write code here
        ListNode res = new ListNode(-1);
        res.next = head;
        //前序节点
        ListNode pre = res;
        //当前节点
        ListNode cur = head;
        //找到m
        for(int i = 1; i < m; i++){
            pre = cur;
            cur = cur.next;
        }
        //从m反转到n
        for(int i = m; i < n; i++){
            ListNode temp = cur.next;
            cur.next = temp.next;
            temp.next = pre.next;
            pre.next = temp;
        }
        //返回去掉表头
        return res.next;
    }

    public static void main(String[] args) {
        Main main = new Main();
//        main.getNums("[[1,0],[0,1]]");
    }
}
