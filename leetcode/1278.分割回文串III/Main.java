import java.util.*;
import java.util.concurrent.*;

public class Main {

    class Fenwick{

        int[] tree;
        int n;
        public Fenwick(int[] nums){
            this.n = nums.length;
            this.tree = new int[n+1];
            for(int i=1;i<=n;i++){
                add(i,nums[i-1]);
                int next = lowBit(i)+i;
                if(next<=n){
                    add(next,tree[i]);
                }
            }
        }

        private int lowBit(int n){
            return n&-n;
        }

        public void update(int index,int value){
            for(int i=index;i<=n;i+=lowBit(i)){
                this.tree[i]+=value;
            }
        }

        public int query(int index){
            int ans = 0;
            while(index>=1){
                ans+=tree[index];
                index-=lowBit(index);
            }
            return ans;
        }

        public void add(int index,int value){
            this.tree[index]+=value;
        }
    }


    class UniondFind{
        int[] root;
        UniondFind(int n){
            root = new int[n];
            for(int i=0;i<n;i++){
                root[i] = i;
            }
        }

        public void union(int x,int y){
            if(x>y){
                union(y,x);
            }
            int rootX = find(x);
            int rootY = find(y);
            root[rootY] = rootX;
        }

        public int find(int x){
            if(x == root[x]){
                return x;
            }
            root[x] = find(root[x]);
            return root[x];
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        UniondFind uf = new UniondFind(n);
        for(int[] edge:edges){
            int node1 = edge[0]-1;
            int node2 = edge[1]-1;
            if(uf.find(node1) != uf.find(node2)){
                uf.union(node1,node2);
            }else{
                return edge;
            }
        }
        return null;
    }

    public int palindromePartition(String s, int k) {
        int n = s.length();
        int[][] cost = new int[n][n];//cost[i][j]表示以i为起点,j是终点，两端闭区间的子串，想要变成回文串的最小代价
        for(int step = 2;step<=n;step++){//子串的长度，长度为1时必定回文，不用处理
            for(int start=0;start<=n-step;start++){//子串的开始下标
                int end = start+step-1;
                cost[start][end] = cost[start+1][end-1] + (s.charAt(start) == s.charAt(end) ? 0:1 );
                //状态转移,从中间向两边扩展
            }
        }
        int[][] dp = new int[n+1][k+1];//dp[i][j]是以i为终点，分割出j个子串的最少花费
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);//后续要不断更新维护最小值，先设置为一个很大的数
        }
        dp[0][0] = 0;//dp边界
        for(int i=1;i<=n;i++){//当前子串终点下标，开区间，实际上是i-1
            for(int j=1;j<=Math.min(i,k);j++){//分割出的子串的数量
                if(j==1){//分割为1个子串
                    dp[i][j] = cost[0][i-1];//只分割为1个子串，那么子串的起点一定是原串的起点也就是0，终点是i-1
                }else{
                    for(int p=j-1;p<i;p++){//由前面的状态转移过来,p代表前一个子串的终点下标
                        //p为什么不从0开始呢，因为要从分割了j-1个子串的状态转移过来
                        //而子串要求非空，因此下标最少也是j-1
                        dp[i][j] = Math.min(dp[i][j],dp[p][j-1]+cost[p][i-1]);
                    }
                }
            }
        }
        return dp[n][k];
    }

    public static void main(String[] args) {
        Main main = new Main();
        int[][] grid = new int[][]{{1,2},{3,4}};
    }
}
