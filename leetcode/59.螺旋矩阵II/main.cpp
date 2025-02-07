class Solution {
public:
    int fun(vector<vector<int>>& nums,int val,int left,int right){//给最外层的一圈赋值，然后像内圈收缩
        for(int i=left;i<right;i++){ 
            nums[left][i]=val;
            val++;
        }
        for(int i=left+1;i<right;i++){
            nums[i][right-1]=val;
            val++;
        }
        for(int i=right-2;i>=left;i--){
            nums[right-1][i]=val;
            val++;
        }
        for(int i=right-2;i>left;i--){
            nums[i][left]=val;
            val++;
        }
        return val;
    }
    
    vector<vector<int>> generateMatrix(int n) {
        vector<vector<int>> res(n,vector<int>(n,0));
        int pos=1;
        int left=0;
        int right=n;
        while(left<right){
            pos = fun(res,pos,left,right);
            left++;
            right--;
        }
        return res;
    }
};