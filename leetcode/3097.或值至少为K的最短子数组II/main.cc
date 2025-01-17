class Solution {
public:
    int minimumSubarrayLength(vector<int>& nums, int k) {
        int left = 0;
        int right = 0;
        vector<int> aim(32,0);
        int index = 0;
        while(k!=0){
            aim[index++] = k%2;
            k/=2;
        }
        vector<int> cur(32,0);
        int ans = INT32_MAX;
        while(right<nums.size()){
            int tmp = nums[right];
            index = 0;
            while(tmp!=0){
                cur[index++] += tmp%2;
                tmp/=2;
            }
            while(left<=right){
                bool flag = true;
                for(int i=31;i>=0;i--){//从高位向低位比
                    if(cur[i]==0&&cur[i]<aim[i]){
                        flag = false;
                        break;
                    }else if(aim[i]==0&&cur[i]>aim[i]){
                        break;
                    }
                }
                if(!flag){
                    break;
                }
                ans = min(ans,right-left+1);
                index = 0;
                tmp = nums[left];
                while(tmp!=0){
                    cur[index++] -= tmp%2;
                    tmp/=2;
                }
                left++;
            }
            right++;
        }
        return ans == INT32_MAX ? -1:ans;
    }
};