class Solution {
   public:
    bool isBalanced(string num) {
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < num.size(); i++) {
            if (i % 2 == 0) {
                count1 += num[i] - '0';
            } else {
                count2 += num[i] - '0';
            }
        }
        return count1 == count2;
    }
};