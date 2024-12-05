class Solution {

    func getColor(a: UInt8,b:UInt8):Int64{
        if(a%2==0){
            if(b%2==0){
                return 1;
            }
            return 0;
        }
        else{
            if(b%2==0){
                return 0;
            }
            return 1;
        }
    }
    func checkTwoChessboards(coordinate1: String, coordinate2: String): Bool {
        var a: UInt8 = 'a';
        var b: UInt8 = '1';
        return getColor(coordinate1[0]-a,coordinate1[1]-b) == getColor(coordinate2[0]-a,coordinate2[1]-b);
    }
}