class Solution {
public:
    vector<int> replaceElements(vector<int>& arr) {
        int n = arr.size();
        vector<int> pre(n,-1);
        for(int i=n-2;i>=0;i--){
            pre[i] = max(pre[i+1],arr[i+1]);
        }
        return pre;
    }
};