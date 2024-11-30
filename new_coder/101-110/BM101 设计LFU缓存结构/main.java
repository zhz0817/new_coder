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
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * lfu design
     * @param operators int整型二维数组 ops
     * @param k int整型 the k
     * @return int整型一维数组
     */
    class Node {
      int key;
      int value;
      int freq;

      public Node(int key, int value, int freq) {
        this.key = key;
        this.value = value;
        this.freq = freq;
      }

      @Override
      public boolean equals(Object o) {
        if (this == o)
          return true;
        if (o == null || getClass() != o.getClass())
          return false;
        Node node = (Node)o;
        return key == node.key && value == node.value && freq == node.freq;
      }

      @Override
      public int hashCode() {
        return Objects.hash(key, value, freq);
      }
    }
    class LFUCache {
      int capacity;
      Map<Integer, Node> map;

      Map<Integer, Deque<Node>> freqMap;
      public LFUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        freqMap = new HashMap<>();
        freqMap.put(1, new LinkedList<>());
      }

      public int get(int key) {
        if (this.capacity == 0)
          return -1;
        if (!map.containsKey(key))
          return -1;
        Node old = map.get(key);
        Node node = new Node(old.key, old.value, 1 + old.freq);
        fun(old, node);
        map.put(key, node);
        return node.value;
      }

      public void fun(Node old, Node node) {
        freqMap.get(old.freq).remove(old);
        if (freqMap.containsKey(old.freq + 1)) {
          freqMap.get(old.freq + 1).offerFirst(node);
        } else {
          Deque<Node> deque = new LinkedList<>();
          deque.offerFirst(node);
          freqMap.put(old.freq + 1, deque);
        }
      }
      public void put(int key, int value) {
        if (this.capacity == 0)
          return;
        if (map.size() == capacity && !map.containsKey(key)) {
          // System.out.println(key);
          int pos = 1;
          while (true) {
            if (freqMap.containsKey(pos)) {
              if (freqMap.get(pos).size() > 0)
                break;
            }
            pos++;
          }
          Node node = freqMap.get(pos).pollLast();
          // System.out.println(node.key+" key");
          map.remove(node.key);
        }
        if (!map.containsKey(key)) {
          Node node = new Node(key, value, 1);
          map.put(key, node);
          freqMap.get(1).offerFirst(node);
        } else {
          Node old = map.get(key);
          Node node = new Node(key, value, old.freq + 1);
          fun(old, node);
          map.put(key, node);
        }
      }
    }

    public int[] LFU(int[][] operators, int k) {
      // write code here
      LFUCache lfuCache = new LFUCache(k);
      List<Integer> list = new ArrayList<>();
      for (int[] tmp : operators) {
        if (tmp[0] == 1) {
          lfuCache.put(tmp[1], tmp[2]);
        } else {
          int value = lfuCache.get(tmp[1]);
          list.add(value);
        }
      }
      int[] ans = new int[list.size()];
      for (int i = 0; i < list.size(); i++) {
        ans[i] = list.get(i);
      }
      return ans;
    }
  }

  public static void main(String[] args) { Main main = new Main(); }
}
