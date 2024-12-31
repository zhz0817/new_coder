import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.*;

public class Main {

    static class TreeNode {
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

    class Fenwick{
        int[] tree;
        int n;
        public Fenwick(int[] nums){
            this.n = nums.length;
            tree = new int[n+1];
            for(int i=1;i<=n;i++){
                tree[i] += nums[i-1];
                int next = lowBit(i)+i;
                if(next<=n){
                    tree[next] += tree[i];
                }
            }
        }

        public int lowBit(int n){
            return n&-n;
        }

        public void update(int index,int value){
            for(int i=index;i<=n;i+=lowBit(i)){
                tree[i]+=value;
            }
        }

        public int sumRange(int index){
            int ans = 0;
            while (index>0){
                ans+=tree[index];
                index-=lowBit(index);
            }
            return ans;
        }
    }

    class Trie{
        boolean isEnd;
        Trie[] children;

        Trie(){
            this.isEnd = false;
            children = new Trie[26];
        }

        public void insert(String s){
            var node = this;
            for(int i=0;i<s.length();i++){
                int index = s.charAt(i)-'a';
                if(node.children[index] == null){
                    node.children[index] = new Trie();
                }
                node = node.children[index];
            }
            node.isEnd = true;
        }

        public List<Integer> search(String s,int pos){
            var node = this;
            List<Integer> ans = new ArrayList<>();
            for(int i=pos;i<s.length();i++){
                int index = s.charAt(i)-'a';
                if(node.children[index] == null){
                    break;
                }
                node = node.children[index];
                ans.add(i-pos+1);//可以存储i-pos+1个字符
            }
            return ans;
        }
    }

    public long minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        int[] rows = horizontalCut;//浅拷贝
        int[] cols = verticalCut;
        Arrays.sort(rows);//默认从小到大排序
        Arrays.sort(cols);
        long ans = 0;
        int index1 = rows.length-1;
        int index2 = cols.length-1;
        long rowCount = 1;
        long colCount = 1;
        while(index1>=0||index2>=0){
            int value1 = index1>=0?rows[index1]:-1;
            int value2 = index2>=0?cols[index2]:-1;
            if(value1>value2){
                ans += rowCount*value1;
                colCount++;
                index1--;
            }else{
                ans += colCount*value2;
                rowCount++;
                index2--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Main main = new Main();
//        main.getNums("[[0,1,0,0,0],[0,1,0,1,0],[0,0,0,1,0]]");
        int[][] nums = new int[][]{{5,35,51},{33,100,18}};
        String[] ss = new String[]{"abcab","a","aab"};
    }
}