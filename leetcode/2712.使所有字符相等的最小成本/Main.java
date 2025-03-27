class Solution {
    int n;
    public long minimumCost(String s) {
        n = s.length();
        List<int[]> list = new ArrayList<>();
        char flag = s.charAt(0);
        int start = 0;
        for(int i=1;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch!=flag){
                list.add(new int[]{start,i-1,flag-'0'});
                flag = ch;
                start=i;
            }
        }
        list.add(new int[]{start,s.length()-1,flag-'0'});
        if(list.size()==1)
            return 0L;
        return change(list);
    }

    public long change(List<int[]> list){
        long ans = 0;
        int left = 0;
        int right = list.size()-1;
        int flag1 = list.get(left)[2];
        int flag2 = list.get(right)[2];
        while (left<right){
            int[] temp1 = list.get(left);
            int[] temp2 = list.get(right);
            int val1 = 1+temp1[1];
            int val2 = this.n-temp2[0];
            if(left+1==right){
                if(flag1==flag2){
                    break;
                }
            }
            if(val1<=val2){
                left++;
                flag1 = list.get(left)[2];
                ans+=val1;
            }
            else{
                right--;
                flag2 = list.get(right)[2];
                ans+=val2;
            }
        }
        return ans;
    }
}