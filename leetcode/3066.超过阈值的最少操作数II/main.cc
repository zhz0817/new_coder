class Solution {
public:
    int minOperations(vector<int>& nums, int k) {
        int ans = 0;
        priority_queue<long long,vector<long long>,greater<long long>> pq;
        for(int n:nums){
            pq.push(n);
        }
        while(pq.size()>=2){
            long long x = pq.top();
            if(x>=k){
                break;
            }
            pq.pop();
            long long y = pq.top();
            pq.pop();
            pq.push(min(x,y)*2+ max(x,y));
            ans++;
        }
        return ans;
    }
};