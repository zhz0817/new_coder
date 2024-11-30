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

  public class Interval {
    int start;
    int end;
    public Interval(int start, int end) {
      this.start = start;
      this.end = end;
    }
  }

  public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
    // write code here
    if (intervals.size() <= 1)
      return intervals;
    Collections.sort(intervals, new Comparator<Interval>() {
      @Override
      public int compare(Interval o1, Interval o2) {
        if (o1.start != o2.start) {
          return o1.start - o2.start;
        }
        return o1.end - o2.end;
      }
    });
    ArrayList<Interval> list = new ArrayList<>();
    int min = intervals.get(0).start;
    int max = intervals.get(0).end;
    for (int i = 1; i < intervals.size(); i++) {
      int left = intervals.get(i).start;
      int right = intervals.get(i).end;
      if (max >= left) {
        max = Math.max(max, right);
      } else {
        list.add(new Interval(min, max));
        min = left;
        max = right;
      }
    }
    list.add(new Interval(min, max));
    return list;
  }

  public static void main(String[] args) { Main main = new Main(); }
}
