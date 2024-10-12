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


    public int InversePairs (int[] nums) { //二分查找
        // write code here
        final int mod = 1000000007;
        int ans = 0;
        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        for(int i=n-1;i>=0;i--){
            int val = nums[i];
            if(list.isEmpty()){
                list.add(val);
            }
            else{
                int left = 0;
                int right = list.size()-1;
                int mid;
                while (left<=right){//寻找插入位置
                    mid = left+(right-left)/2;
                    int temp = list.get(mid);
                    if(temp<val){
                        left=mid+1;
                    }
                    else{
                        right = mid-1;
                    }
                }
                ans+=left;//有几个数比它大
                ans%=mod;
                list.add(left,val);//插入指定位置
            }
        }
        return ans;
    }
    
    public static void main(String[] args) {
        Main main = new Main();
    }
}
