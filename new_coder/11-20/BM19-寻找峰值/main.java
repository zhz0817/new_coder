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
        public ListNode(int val) {
            this.val = val;
        }
    }

    public void getNums(String s){
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='['){
                sb.append('{');
            }else if(ch==']'){
                sb.append('}');
            }else if(ch=='"'){
                sb.append("'");
            } else{
                sb.append(ch);
            }
        }
        System.out.println(sb.toString());
    }


    public int findPeakElement (int[] nums) {
        // write code here
        int left = 0;
        int right = nums.length-1;
        int mid;
        while(left<right){
            mid = left+(right-left)/2;
            if(nums[mid]>nums[mid+1])
                right=mid;
            else
                left=mid+1;
        }
        return right;
    }
    
    public static void main(String[] args) {
        Main main = new Main();
    }
}
