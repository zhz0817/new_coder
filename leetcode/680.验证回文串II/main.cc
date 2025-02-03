class Solution {
public:
    bool check(string s,int low,int high){
        while(low<high){
            if(s[low]==s[high]){
                low++;
                high--;
            }
            else{
                return false;
            }
        }
        return true;
    }
    bool validPalindrome(string s) {
        int low=0;
        int high=s.size()-1;
        while(low<high){
            if(s[low]==s[high]){
                low+=1;
                high-=1;
            }
            else{
                return check(s,low+1,high)||check(s,low,high-1);//只给一次机会，但是可以移动左指针或者右指针
            }
        }
        return true;
    }
};