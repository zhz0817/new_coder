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


    public boolean isBalanced(String num) {
        int sum1 = 0;
        int sum2 = 0;
        for(int i=0;i<num.length();i++){
            int value = num.charAt(i)-'0';
            if(i%2==0){
                sum1+=value;
            }else{
                sum2+=value;
            }
        }
        return sum1==sum2;
    }


    class NumArray {

        int[] tree;
        int lowbit(int x) {
            return x & -x;
        }
        int query(int x) {
            int ans = 0;
            for (int i = x; i > 0; i -= lowbit(i))
                ans += tree[i];
            return ans;
        }
        void add(int x, int u) {
            for (int i = x; i <= n; i += lowbit(i))
                tree[i] += u;
        }

        int[] nums;
        int n;
        public NumArray(int[] _nums) {
            nums = _nums;
            n = nums.length;
            tree = new int[n + 1];
            for (int i = 0; i < n; i++)
                add(i + 1, nums[i]);
        }

        public void update(int i, int val) {
            add(i + 1, val - nums[i]);
            nums[i] = val;
        }

        public int sumRange(int l, int r) {
            return query(r + 1) - query(l);
        }
    }


    public int numRookCaptures(char[][] board) {
        int x = -1,y = -1;
        boolean flag = true;
        for(int i=0;i<8;i++){
            for (int j = 0; j < 8; j++) {
                if(board[i][j]=='R'){
                    x = i;y = j;
                    flag = false;
                    break;
                }
            }
            if(!flag){
                break;
            }
        }
        int res = 0;
        for(int i=x-1;i>=0;i--){
            char ch = board[i][y];//x逐渐减少,y不变，在一条直线上。
            if(ch=='p'){
                res++;
                break;//注意题干是一步能捕获的棋子,捕获了一个就要break
            }
            else if(ch=='B')//被自己家的象阻拦，无法继续遍历，break
                break;
        }
        for(int i=x+1;i<8;i++){//8*8的棋盘，数组下标0-7闭区间
            char ch = board[i][y];//x逐渐增加,y不变，在一条直线上。
            if(ch=='p'){
                res++;
                break;
            }
            else if(ch=='B')
                break;
        }
        for(int i=y-1;i>=0;i--){
            char ch = board[x][i];//x不变,y逐渐减少，在一条直线上。
            if(ch=='p'){
                res++;
                break;
            }
            else if(ch=='B')
                break;
        }
        for(int i=y+1;i<8;i++){
            char ch = board[x][i];//x不变,y逐渐增大，在一条直线上。
            if(ch=='p'){
                res++;
                break;
            }
            else if(ch=='B')
                break;
        }
        return res;
    }

    public static void main(String[] args) {
        Main main = new Main();
//        main.getNums("[[0,1,0,0,0],[0,1,0,1,0],[0,0,0,1,0]]");
        int[][] nums = new int[][]{{5,35,51},{33,100,18}};
        String[] ss = new String[]{"abcab","a","aab"};
    }
}