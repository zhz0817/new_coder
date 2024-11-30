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

  List<Integer> list = new ArrayList<>();

    public int binarySearch(int value){
        if(list.isEmpty()){
            return 0;
        }
        int left = 0;
        int right = list.size();
        int mid;
        while (left<right){
            mid = left+(right-left)/2;
            if(list.get(mid)>=value){
                right=mid;//right是大于等于value的第一个位置，正好是插入位置
            }else{
                left=mid+1;
            }
        }
        return right;
    }
    public void Insert(Integer num) {
        int index = binarySearch(num);
        list.add(index,num);
    }

    public Double GetMedian() {
        if(list.isEmpty()){
            return 0.0;
        }
        if(list.size()%2==0){
            double ans = (double) (list.get(list.size() / 2 - 1) + list.get(list.size() / 2));
            return ans/2;
        }else{
            return Double.valueOf(list.get(list.size()/2));
        }
    }
  

  
  public static void main(String[] args) { Main main = new Main(); }
}
