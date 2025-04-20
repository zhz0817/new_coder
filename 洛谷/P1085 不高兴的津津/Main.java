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


    public static void main(String[] args) throws IOException {
//        StreamTokenizer sc =new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
//        sc.nextToken();
//        BigDecimal bd = new BigDecimal(String.valueOf(ans));
//        String z = String.valueOf(bd.setScale(1, RoundingMode.HALF_UP));
        int ans = 0;
        int max = 0;
        for(int i=0;i<7;i++){
            String s = in.readLine();
            String[] ss = s.split(" ");
            int count  = Integer.parseInt(ss[0])+Integer.parseInt(ss[1]);
            if(count>8&&count>max){
                ans = i+1;
                max = count;
            }
        }
        PrintWriter out = new PrintWriter(System.out);
        out.println(ans);
        out.flush();	//关闭输出流
    }
}