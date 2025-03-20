class Solution {
    public boolean isPrime(int n){
        if(n==2)
            return true;
        if(n<=1)
            return false;
        if(n%2==0)
            return false;
        for(int i=3;i<=(int)Math.sqrt(n);i+=2){
            if(n%i==0)
                return false;
        }
        return true;
    }
    public int diagonalPrime(int[][] nums) {
        int ans = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            int j = n-i-1;
            if(isPrime(nums[i][i]))
                ans = Math.max(ans,nums[i][i]);
            if(isPrime(nums[i][j]))
                ans = Math.max(ans,nums[i][j]);
        }
        return ans;
    }
}