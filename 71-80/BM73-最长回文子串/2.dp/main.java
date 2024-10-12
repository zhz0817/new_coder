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
    public ListNode(int val) { this.val = val; }
  }

  public void getNums(String s) {
    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (ch == '[') {
        sb.append('{');
      } else if (ch == ']') {
        sb.append('}');
      } else if (ch == '"') {
        sb.append("'");
      } else {
        sb.append(ch);
      }
    }
    System.out.println(sb.toString());
  }

// https://www.cnblogs.com/cloudplankroader/p/10988844.html
  public void manacher(String s, int n, int[] mp) {
    StringBuilder ms = new StringBuilder();
    ms.append("#");
    // 预处理
    for (int i = 0; i < n; i++) {
      // 使之都变成奇数回文子串
      ms.append(s.charAt(i));
      ms.append("#");
    }
    // 目前已知的最长回文子串的最右一位的后一位
    int maxpos = 0;
    // 当前的最长回文子串的中心点
    int index = 0;
    // index - j = i-index 
    // j = 2*index-i
    for (int i = 0; i < ms.length(); i++) {
      // 第一步直接取得可能的最短的回文半径，当i>R时，最短的回文半径是1，反之，最短的回文半径可能是i对应的i'的回文半径或者i到R的距离
      mp[i] = maxpos > i ? Math.min(mp[2 * index - i], maxpos - i) : 1;
      while (i - mp[i] >= 0 && i + mp[i] < ms.length() &&
             ms.charAt(i + mp[i]) == ms.charAt(i - mp[i]))
        // 两边扫
        mp[i]++;
      // 更新位置
      if (i + mp[i] > maxpos) {
        maxpos = i + mp[i];
        index = i;
      }
    }
  }
  public int getLongestPalindrome(String A) {
    int n = A.length();
    // 记录回文子串长度
    int[] mp = new int[2 * n + 1];
    manacher(A, n, mp);
    int maxlen = 0;
    // 遍历数组
    for (int i = 0; i < 2 * n + 1; i++)
      // 找到最大的长度
      maxlen = Math.max(maxlen, mp[i] - 1);
    return maxlen;
  }

  public static void main(String[] args) { Main main = new Main(); }
}
