class Solution {
public:
    int countKeyChanges(string s) {
        int ans = 0;
        int pre = s[0];
        for(int i=1;i<s.size();i++){
            if(s[i]==pre||s[i]-32==pre||s[i]+32==pre){

            }else{
                ans++;
            }
            pre = s[i];
        }
        return ans;
    }
};