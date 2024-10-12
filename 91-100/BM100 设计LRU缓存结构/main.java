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

  public class Solution {

    Map<Integer, Integer> map;
    Deque<Integer> list;
    int capacity;
    public Solution(int capacity) {
      // write code here
      map = new HashMap<>();
      list = new LinkedList<>();
      this.capacity = capacity;
    }

    public int get(int key) {
      // write code here
      if (map.containsKey(key)) {
        list.remove(key);
        list.addFirst(key);
        return map.get(key);
      }
      return -1;
    }

    public void set(int key, int value) {
      // write code here
      if (map.containsKey(key)) {
        map.put(key, value);
        list.remove(key);
        list.addFirst(key);
      } else {
        if (list.size() < capacity) {
          list.addFirst(key);
          map.put(key, value);
        } else {
          int temp = list.getLast();
          list.removeLast();
          map.remove(temp);
          list.addFirst(key);
          map.put(key, value);
        }
      }
    }
  }

  public static void main(String[] args) { Main main = new Main(); }
}
