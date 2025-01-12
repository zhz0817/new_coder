class Solution {
public:
    int largestCombination(vector<int>& candidates) {
        vector<int> all(32,0);
        for(int i=0;i<candidates.size();i++){
            int tmp = candidates[i];
            int index = 0;
            while(tmp!=0){
                int value = tmp%2;
                if(value==1){
                    all[index]++;
                }
                index++;
                tmp/=2;
            }
        }
        int ans = 0;
        for(int i=0;i<32;i++){
            ans = max(ans,all[i]);
        }
        return ans;
    }
};