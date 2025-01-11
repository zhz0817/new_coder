class Solution {
public:
    vector<int> toList(int num){
        vector<int> ans(4,0);
        int index = 3;
        while(num!=0){
            ans[index--]=num%10;
            num/=10;
        }
        return ans;
    }
    int generateKey(int num1, int num2, int num3) {
        vector<int> t1 = toList(num1);
        vector<int> t2 = toList(num2);
        vector<int> t3 = toList(num3);
        int v1 = min(t1[0],min(t2[0],t3[0]));
        int v2 = min(t1[1],min(t2[1],t3[1]));
        int v3 = min(t1[2],min(t2[2],t3[2]));
        int v4 = min(t1[3],min(t2[3],t3[3]));
        return v1*1000+v2*100+v3*10+v4;
    }
};