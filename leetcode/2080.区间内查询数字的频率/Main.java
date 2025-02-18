class RangeFreqQuery {
    Map<Integer, List<Integer>> map;
    public RangeFreqQuery(int[] arr) {
        map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int m = arr[i];
            List<Integer> list = map.getOrDefault(m, new ArrayList<>());
            list.add(i);
            map.put(m, list);
        }
    }

    public int query(int left, int right, int value) {
        if (!map.containsKey(value))
            return 0;
        List<Integer> list = map.get(value);
        int l = getLeftIndex(list, left);
        if (l == -1)
            return 0;
        int r = getRightIndex(list, right);
        return r - l + 1;
    }

    private int getLeftIndex(List<Integer> list, int target) {
        int left = 0;
        int right = list.size() - 1;
        int ans = -1;
        int mid;
        while (left <= right) {
            mid = (left + right) >> 1;
            if (list.get(mid) >= target) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    private int getRightIndex(List<Integer> list, int target) {
        int left = 0;
        int right = list.size() - 1;
        int ans = -1;
        int mid;
        while (left <= right) {
            mid = (left + ((right - left) >> 1));
            if (list.get(mid) <= target) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}

/**
 * Your RangeFreqQuery object will be instantiated and called as such:
 * RangeFreqQuery obj = new RangeFreqQuery(arr);
 * int param_1 = obj.query(left,right,value);
 */