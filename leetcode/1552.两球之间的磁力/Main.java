class Solution {
    int n;
    
    public int maxDistance(int[] price, int k) {
        this.n = price.length;
        Arrays.sort(price);
        int left = 0;
        int right = price[n-1];
        int ans = 0;
        while (left<right){
            int mid = left+(right-left)/2;
            if(check(price,mid,k)){
                ans = mid;
                left = mid+1;
            }
            else{
                right = mid;
            }
        }
        return ans;
    }
    public boolean check(int[] price,int val,int k){
        int pre = price[0];
        int count = 1;
        for(int i=1;i<n;i++){
            if(pre+val<=price[i]){
                count++;
                pre = price[i];
            }
            if(count==k)
                return true;
        }
        return false;
    }
}