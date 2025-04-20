class Solution {
    public int minOperations(int[] nums, int k) {
        Arrays.sort(nums);
        if(nums[0] < k){
            return -1;
        }
        Map<Integer,Integer> map = new HashMap<>();
        for(int n:nums){
            map.put(n,1+map.getOrDefault(n,0));
        }
        if(nums[0] == k){
            return map.size()-1;
        }
        return map.size();
    }
}