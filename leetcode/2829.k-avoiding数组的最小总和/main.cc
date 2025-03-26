class Solution {
public:
    int minimumSum(int n, int k) {
        int sum = 1;
        int count = 1;
        unordered_set<int> set1;
        set1.insert(1);
        for(int i=2;i<=INT32_MAX&&count<n;i++){
            int v = k-i;
            if(set1.find(v) == set1.end()){
                set1.insert(i);
                count++;
                sum+=i;
            }
        }
        return sum;
    }
};