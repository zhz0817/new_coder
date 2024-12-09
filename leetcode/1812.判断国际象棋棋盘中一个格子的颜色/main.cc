class Solution {
public:
    bool squareIsWhite(string coordinates) {
        int v1 = (coordinates[0]-'a')%2;
        int v2 = (coordinates[1]-'1')%2;
        return (v1&&!v2)||(!v1&&v2);
    }
};