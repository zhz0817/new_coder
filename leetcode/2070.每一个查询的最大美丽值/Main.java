class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, (a, b) -> a[0] - b[0]);
        Map<Integer, Integer> map = new HashMap<>();
        map.put(items[0][0], items[0][1]);
        int max1 = items[0][1];
        for (int i = 1; i < items.length; i++) {
            int temp1 = items[i][0];
            int temp2 = items[i][1];
            max1 = Math.max(max1, temp2);
            map.put(temp1, max1);
        }
        int[] res = new int[queries.length];
        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        for (int i = 0; i < queries.length; i++) {
            int price = queries[i];
            int index = binarySearch(list, price);
            if (index == -1) {
                res[i] = 0;
            } else if (index == list.size()) {
                res[i] = map.get(list.get(list.size() - 1));
            } else {
                res[i] = map.get(list.get(index));
            }
        }
        return res;
    }
    public int binarySearch(List<Integer> list, int val) {
        int left = 0;
        int right = list.size() - 1;
        int ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) <= val) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}