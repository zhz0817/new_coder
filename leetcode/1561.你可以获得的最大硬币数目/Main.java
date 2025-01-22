class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int left = 0;
        int res=0;//每次要最左边的第一个和最右边的两个
        for(int i=piles.length-2;i>left;i-=2){
            res+=piles[i];
            left++;
        }
        return res;
    }
}
