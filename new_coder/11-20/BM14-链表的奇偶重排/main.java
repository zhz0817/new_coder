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



    public ListNode oddEvenList (ListNode head) {
        // write code here
        if(head==null){
            return null;
        }
        List<ListNode> list = new ArrayList<>();
        ListNode ans = head;
        ListNode node = ans;
        while (head!=null){
            list.add(head);
            head = head.next;
        }
        for(int i=2;i<list.size();i+=2){
            node.next = list.get(i);
            node = node.next;
        }
        for(int i=1;i<list.size();i+=2){
            node.next = list.get(i);
            node = node.next;
        }
        node.next = null;
        return ans;
    }
    
    public static void main(String[] args) {
        Main main = new Main();
    }
}
