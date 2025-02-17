class Solution {
   public:
    int findSpecialInteger(vector<int>& arr) {
        int count = 1;
        int pre = arr[0];
        int n = arr.size();
        int max = n / 4;
        for (int i = 1; i < n; i++) {
            if (arr[i] == pre) {
                count++;
                if (count * 4 > n) {
                    return pre;
                }
            } else {
                pre = arr[i];
                count = 1;
            }
        }
        return pre;
    }
};