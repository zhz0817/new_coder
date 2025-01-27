class Solution {
    public int jump(int[] nums) {
        int length = nums.length;
        int[] dis = new int[length];
        dis[length-1]=0;
        for(int i=length-2;i>=0;i--){
            if(nums[i]>=length-i-1)//能直接到终点
                dis[i]=1;
            else{
                if(nums[i]==0){
                    dis[i]=-1;
                    continue;
                }
                int min = Integer.MAX_VALUE;
                for(int j=i+1;j<i+1+nums[i];j++){
                    if(dis[j]<min&&dis[j]>0)
                        min=dis[j];
                }
                min++;
                dis[i]=min;
            }
        }
        return dis[0];
    }
}