class Solution {
    public int divisorSubstrings(int num, int k) {
        List<Integer> list = new ArrayList<>();
        int n = num;
        while (num != 0) {
            list.add(num % 10);
            num /= 10;
        }
        Collections.reverse(list); // 得到num里的每一位
        int max = (int) Math.pow(10, k - 1);
        int left = 0;
        int right = 0;
        int ans = 0;
        int tmp = 0;
        while (right < list.size()) {
            tmp *= 10;
            tmp += list.get(right);
            if (right - left == k - 1) {
                if (tmp != 0 && n % tmp == 0) {
                    ans++;
                }
                tmp %= max;
                left++;
            }
            right++;
        }
        return ans;
    }
}