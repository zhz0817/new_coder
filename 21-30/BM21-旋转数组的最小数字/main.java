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


    public int minNumberInRotateArray (int[] array) {
        // write code here
        if(array.length==1)
            return array[0];
        int left = 0;
        int right = array.length-1;
        int mid;
        while(left<right){
            mid = left+(right-left)/2;
            if(array[mid]>array[right]){
                left=mid+1;
            }
            else if(array[mid]<array[right]){
                right=mid;
            }
            else
                right--;
        }
        return array[right];
    }
    
    public static void main(String[] args) {
        Main main = new Main();
    }
}
