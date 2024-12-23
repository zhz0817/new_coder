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
    public int minValidStrings(String[] words, String target) {
        int n = target.length();
        int[] dp = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        Trie trie = new Trie();
        for(String word:words){
            trie.insert(word);
        }
        for(int i=0;i<n;i++){ //向后搜索的动态规划
            if(dp[i] == Integer.MAX_VALUE){
                continue;
            }
            List<Integer> res = trie.search(target,i);
            for(Integer len:res){
                dp[i+len] = Math.min(dp[i+len],dp[i]+1);
            }
        }
        return dp[n] == Integer.MAX_VALUE?-1:dp[n];
    }

    class ExamRoom {
        private int getDist(int[] s){ //获取区间内节点到两侧端点的最大距离
            int left = s[0],right = s[1];//区间的左右端点，注意两次都是开区间，
            if(left == -1){
                return right;
            }
            if(right == N){
                return N-left-1;
            }
            return (right-left)>>1;//相当于除以2，向下取整
        }
        private TreeSet<int[]> set1 = new TreeSet<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int dist1 = getDist(o1);
                int dist2 = getDist(o2);
                if(dist1!=dist2){
                    return dist2-dist1;//距离从大到小排序
                }
                return o1[0]-o2[0];//距离相同，按照下标从小到大排序
            }
        });
        private Map<Integer,Integer> left = new HashMap<>();//节点左侧已经有人坐的最近的座位的坐标
        private Map<Integer,Integer> right = new HashMap<>();//节点右侧已经有人坐的最近的座位的坐标
        int N;

        private void add(int[] s){
            set1.add(s);
            left.put(s[1],s[0]);
            right.put(s[0],s[1]);
        }

        private void del(int[] s){
            set1.remove(s);
            left.remove(s[1]);
            right.remove(s[0]);
        }
        public ExamRoom(int n) {
            this.N = n;
            add(new int[]{-1,n});//注意左右两侧都是开区间
        }

        public int seat() {
            int[] s = set1.first();//能插入的，距离能达到最大的区间
            int mid = s[0]+((s[1]-s[0])>>1);//避免int溢出
            if(s[0]==-1){
                mid = 0;//插最左边
            }else if(s[1] == N){
                mid = N-1;//插右边
            }
            del(s);
            add(new int[]{s[0],mid});//注意左右两侧都是开区间
            add(new int[]{mid,s[1]});//注意左右两侧都是开区间
            return mid;
        }

        public void leave(int p) {
            int l = left.get(p);
            int r = right.get(p);
            del(new int[]{l,p});//删除两个小区间，合并成一个大区间
            del(new int[]{p,r});
            add(new int[]{l,r});
        }
    }


    public static void main(String[] args) {
        Main main = new Main();
//        main.getNums("[[0,1,0,0,0],[0,1,0,1,0],[0,0,0,1,0]]");
        int[][] nums = new int[][]{{5,35,51},{33,100,18}};
        String[] ss = new String[]{"abcab","a","aab"};
    }
}