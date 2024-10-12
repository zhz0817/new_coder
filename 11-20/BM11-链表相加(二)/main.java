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


    class UnionFind{
        int[] parent;
        int[] rank;

        int count;
        public UnionFind(int n){
            parent = new int[n];
            rank = new int[n];
            count = n-1;
            for(int i=0;i<n;i++){
                parent[i]=i;
                rank[i]=1;
            }
        }

        public UnionFind(UnionFind other){
            parent = new int[other.parent.length];
            rank = new int[other.rank.length];
            count = other.count;
            for(int i=0;i<parent.length;i++){
                parent[i] = other.parent[i];
                rank[i] = other.rank[i];
            }
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
                count--;
            }
        }

        public boolean isConnected(int x,int y){
            return find(x)==find(y);
        }
    }

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n+1);
        int count = 0;
        int count1 = 0;
        int count2 = 0;
        for(int[] edge:edges){
            if(edge[0]==3){
                if(!uf.isConnected(edge[1],edge[2])){
                    count++;
                    uf.union(edge[1],edge[2]);
                }
            }
        }
        UnionFind uf1 = new UnionFind(uf);
        for(int[] edge:edges){
            if(edge[0]==1){
                if(!uf.isConnected(edge[1],edge[2])){
                    count1++;
                    uf.union(edge[1],edge[2]);
                    if(uf.count==1){
                        break;
                    }
                }
            }
        }
        for(int[] edge:edges){
            if(edge[0]==2){
                if(!uf1.isConnected(edge[1],edge[2])){
                    count2++;
                    uf1.union(edge[1],edge[2]);
                    if(uf1.count==1){
                        break;
                    }
                }
            }
        }
        if(uf.count!=1||uf1.count!=1){
            return -1;
        }
        return edges.length-count-count1-count2;
    }

    public ListNode ReverseList (ListNode head) {
        // write code here
        ListNode pre = null;
        ListNode cur = head;
        while (cur!=null){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
    public ListNode addInList (ListNode head1, ListNode head2) {
        // write code here
        ListNode l1 = ReverseList(head1);
        ListNode l2 = ReverseList(head2);
        ListNode ans = new ListNode(-1);
        ListNode node = ans;
        int tmp = 0;
        while(l1!=null||l2!=null||tmp!=0){
            int value1 = l1==null?0:l1.val;
            int value2 = l2==null?0:l2.val;
            int sum = value1+value2+tmp;
            node.next = new ListNode(sum%10);
            node = node.next;
            tmp = sum/10;
            if(l1!=null)
                l1 = l1.next;
            if(l2!=null)
                l2 = l2.next;
        }
        return ReverseList(ans.next);
    }

    public static void main(String[] args) {
        Main main = new Main();
//        main.getNums("[[3,1,2],[3,2,3],[1,1,4],[2,1,4]]");
//        main.maxNumEdgesToRemove(4,new int[][]{{3,1,2},{3,2,3},{1,1,4},{2,1,4}});
        ListNode node1 = new ListNode(9);
        node1.next = new ListNode(3);
        node1.next.next = new ListNode(7);
        ListNode node2 = new ListNode(6);
        node2.next = new ListNode(3);
        main.addInList(node1,node2);
    }
}
