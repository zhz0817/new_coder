import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.*;
public class Main {

    public void getNums(String s){
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='[') {
                sb.append('{');
            } else if(ch==']') {
                sb.append('}');
            } else {
                sb.append(ch);
            }
        }
        System.out.println(sb.toString());
    }

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }

//    public int gcd(int a,int b){
//        int ans = b;
//        while (a%b!=0){
//            ans = a%b;
//            a=b;
//            b=ans;
//        }
//        return ans;
//    }
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode ans = head;
        while (head!=null&&head.next!=null){
            int val1 = head.val;
            int val2 = head.next.val;
            int temp = gcd(Math.max(val1,val2),Math.min(val1,val2));
            ListNode t = head.next;
            head.next = new ListNode(temp);
            head.next.next = t;
            head = head.next.next;
        }
        return ans;
    }

    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        int[] ans = new int[n];
        for(int i=0;i<n;i++){
            set1.add(A[i]);
            set2.add(B[i]);
            int count = 0;
            for(Integer integer:set1){
                if(set2.contains(integer))
                    count++;
            }
            ans[i]=count;
        }
        return ans;
    }

    public int maximizeTheProfit(int n, List<List<Integer>> offers) {
        List<int[]>[] list = new ArrayList[n];
        for(int i=0;i<n;i++)
            list[i] = new ArrayList<>();
        for(List<Integer> offer:offers){
            list[offer.get(1)].add(new int[]{offer.get(0),offer.get(2)});
        }
        int[] dp = new int[n+1];
        for(int i=0;i<n;i++){
            dp[i+1] = dp[i];
            for(int[] nums:list[i]){
                dp[i+1] = Math.max(dp[i+1],dp[nums[0]]+nums[1]);
            }
        }
        return dp[n];
    }

    public int findStone (int[] arr) {
        // write code here
        Map<Integer,Integer> map = new HashMap<>();
        int ans = -1;
        for(int n:arr){
           map.put(n,1+map.getOrDefault(n,0));
        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getKey().equals(entry.getValue())){
                ans = Math.max(ans,entry.getKey());
            }
        }
        return ans;
    }





    public int treasureGame (int[] treasureValue) {
        // write code here
        int ans = 0;
        int n = treasureValue.length;
        long[] sum = new long[n+1];
        for(int i=1;i<=n;i++)
            sum[i] = sum[i-1]+treasureValue[i-1];
        int left = 0;
        int right = n-1;
        int mid = 0;
        while (left<right){
            int index = -1;
            int min = Integer.MAX_VALUE;
            for(int i=left;i<=right;i++){
                long val1 = sum[i+1]-sum[left];
                long val2 = sum[right+1]-sum[i+1];
                long val = Math.abs(val1-val2);
                if(val<min){
                    index=i;
                    min= (int) val;
                }
            }
            mid = index;
            long l = sum[mid+1]-sum[left];
            long r = sum[right+1]-sum[mid+1];
            if(l<r){
                ans+=l;
                right=mid;
            }
            else if(l>r){
                ans+=r;
                left=mid+1;
            }
            else{
                int[] temp1 = new int[mid-left+1];
                int[] temp2 = new int[right-mid];
                for(int i=0;i<temp1.length;i++)
                    temp1[i] = treasureValue[left+i];
                for(int i=0;i<temp2.length;i++)
                    temp2[i]=treasureValue[mid+i];
                int ans1 = treasureGame(temp1);
                int ans2 = treasureGame(temp2);
                if(ans1>ans2){
                    ans+=ans1;
                }
                else{
                    ans+=ans2;
                }
                break;
            }
        }
        return ans;
    }

//    static class Monster{
//        Integer x;
//        Integer y;
//        Integer weight;
//        Integer count;
//        Integer up;
//
//        public Monster(Integer x, Integer y, Integer weight, Integer count, Integer up) {
//            this.x = x;
//            this.y = y;
//            this.weight = weight;
//            this.count = count;
//            this.up = up;
//        }
//    }
//
//    public static int fun(int weight,Monster monster1,Monster monster2,int n){
//        int x = 1;
//        int y = 1;
//        int count = Math.abs(monster1.x-x)+Math.abs(monster1.y-y);
//        int t = count/monster1.count;
//        int v = monster1.weight+t*monster1.up;
//        weight-=v;
//        count++;
//        count+=Math.abs(monster1.x-monster2.x)+Math.abs(monster1.y-monster2.y);
//        t = count/monster2.count;
//        v = monster2.weight+t*monster2.up;
//        weight-=v;
//        return weight;
//    }

    static Map<Integer,Integer> map = new HashMap<>();
    public static int fun(int[] nums,int index){
        if(map.containsKey(index)){
            return map.get(index);
        }
        if(index==0){
            map.put(0,-1);
            return -1;
        }
        int min = nums[index];
        int ans = -1;
        for(int i=index-1;i>=0;i--){
            if(nums[i]<min){
                min = nums[i];
                ans = i;
            }
        }
        map.put(index,ans);
        return ans;
    }

    public static int gcd(int a,int b){
        int ans = b;
        while (a%b!=0){
            ans = a%b;
            a=b;
            b=ans;
        }
        return ans;
    }

    static Set<String> set = new HashSet<>();
    static int ans = 0;
    public static void dfs(String s,int index,StringBuffer sb1,Map<Integer,List<Integer>> map,
                           int n,Set<Integer> set1){
        if(sb1.length()==n){
//            System.out.println(sb1.toString());
            for(int i=0;i+3<=sb1.length();i++){
                if(sb1.substring(i,i+3).equals("mhy")){
                    ans+=(sb1.length()-i)-2;
                }
            }
            return;
        }
        List<Integer> list = map.get(index+1);
        for(int i=0;i<list.size();i++){
            int pos = list.get(i)-1;
            if(set1.contains(pos))
                continue;
            set1.add(pos);
            sb1.append(s.charAt(pos));
            dfs(s,pos,sb1,map,n,set1);
            sb1.deleteCharAt(sb1.length()-1);
            set1.remove(pos);
        }
    }
    public static void main(String[] args) throws IOException {
//        StreamTokenizer sc =new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
//        sc.nextToken();
        String s = in.readLine();
        String[] ss = s.split(" ");
        int[] nums = new int[ss.length];
        for(int i=0;i<ss.length;i++)
            nums[i] = Integer.parseInt(ss[i]);
        int ans = nums[0]*10+nums[1];
//        BigDecimal bd = new BigDecimal(String.valueOf(ans));
//        String z = String.valueOf(bd.setScale(1, RoundingMode.HALF_UP));
        PrintWriter out = new PrintWriter(System.out);
        out.println(ans/19);
        out.flush();	//关闭输出流
    }
}