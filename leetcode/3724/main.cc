class Solution {
public:
    int getColor(int a,int b){
        if(a%2==0){
            if(b%2==0){
                return 1;
            }
            return 0;
        }else{
            if(b%2==0){
                return 0;
            }
            return 1;
        }
    }
    bool checkTwoChessboards(string coordinate1, string coordinate2) {
        return getColor(coordinate1[0]-'a',coordinate1[1]-'1') == getColor(coordinate2[0]-'a',coordinate2[1]-'1');
    }
};