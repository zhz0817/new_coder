import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
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
    static public class TreeNode {
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


    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            char ch1 = text1.charAt(i-1);
            for(int j=1;j<=n;j++){
                char ch2 = text2.charAt(j-1);
                if(ch1==ch2){
                    dp[i][j] = 1+dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int n = scanner.nextInt();
        int ans = 0;
        String[] ss = s.split(" ");
        for(String t:ss){
            int val = Integer.valueOf(t);
            if(n+30>=val)
                ans++;
        }
        System.out.println(ans);
    }
}