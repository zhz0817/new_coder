class Solution {
public:
    int maxDistance(vector<vector<int>>& arrays) {
        int min1 = INT32_MAX;
        int max1 = INT32_MIN;
        int min2 = INT32_MAX;
        int max2 = INT32_MIN;
        int index1 = -1;
        int index2 = -1;
        for(int i=0;i<arrays.size();i++){
            int left = arrays[i][0];
            int right = arrays[i][arrays[i].size()-1];
            if(left<=min2){
                if(left<=min1){
                    min2 = min1;
                    min1 = left;
                    index1 = i;
                }else{
                     min2 = left;
                }
            }
            if(right>=max2){
                if(right>=max1){
                    max2 = max1;
                    max1 = right;
                    index2 = i;
                }else{
                    max2 = right;
                }
            }
        }
        if(index1 != index2){
            return max1-min1;
        }
        return max(max2-min1,max1-min2);
    }
};