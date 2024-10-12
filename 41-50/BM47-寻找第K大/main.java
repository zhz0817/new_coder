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

  public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
    // write code here
    Queue<Integer> queue = new PriorityQueue<>((a, b) -> a.compareTo(b));
    for (int n : input) {
      queue.offer(n);
    }
    ArrayList<Integer> ans = new ArrayList<>();
    while (k-- > 0 && !queue.isEmpty()) {
      ans.add(queue.poll());
    }
    return ans;
  }

  public int partition(int[] arr, int left, int right) {
    int value = arr[left];
    int l = left;
    int r = right;
    while (l < r) {
      while (r > l && arr[r] >= arr[l]) {
        r--;
      }
      if (r > l) {
        int tmp = arr[r];
        arr[r] = arr[l];
        arr[l] = tmp;
      }
      while (r > l && arr[r] >= arr[l]) {
        l++;
      }
      if (r > l) {
        int tmp = arr[r];
        arr[r] = arr[l];
        arr[l] = tmp;
      }
    }
    arr[l] = value;
    return l;
  }
  public void quickSort(int[] arr, int left, int right) {
    if (left >= right) {
      return;
    }
    int index = partition(arr, left, right);
    quickSort(arr, left, index - 1);
    quickSort(arr, index + 1, right);
  }

  public int findKth(int[] a, int n, int K) {
    // write code here
    quickSort(a, 0, n - 1);
    return a[n - K];
  }
  public static void main(String[] args) { Main main = new Main(); }
}
