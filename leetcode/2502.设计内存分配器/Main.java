class Allocator {
    List<int[]> list = new ArrayList<>(); // 随时维护list的有序性
    Map<Integer, List<Integer>> map =
        new HashMap<>(); // 存储id为mID的所有下标的起点
    int capacity;
    public Allocator(int n) {
        this.capacity = n;
        list.add(new int[] {
            -1, 1}); // 左侧哨兵，数组{-1,1}的含义是下标-1处被占用，占用长度是1
    }

    public int allocate(int size, int mID) {
        for (int i = 0; i < list.size(); i++) {
            int curEnd = list.get(i)[0]
                + list.get(i)[1]; // 当前区间的终点，闭区间，没有被分配内存
            int nextStart; // 下一个区间的起点，开区间，已经被分配内存
            if (i == list.size() - 1) {
                nextStart = this.capacity;
            } else {
                nextStart = list.get(i + 1)[0];
            }
            int length = nextStart - curEnd;
            if (length >= size) {
                if (map.containsKey(mID)) {
                    map.get(mID).add(curEnd);
                } else {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(curEnd);
                    map.put(mID, tmp);
                }
                list.add(new int[] {curEnd, size});
                Collections.sort(list, new Comparator<int[]>() { //可以用二分查找优化
                    @Override
                    public int compare(int[] o1, int[] o2) {
                        return o1[0] - o2[0];
                    }
                }); // 按照数组下标从小到大排序
                return curEnd; // 如果区间直接的间隔够大足够分配，那么尽量靠左分配
            }
        }
        return -1;
    }

    public int freeMemory(int mID) {
        if (!map.containsKey(mID)) {
            return 0;
        }
        List<Integer> tmp = map.get(mID);
        int ans = 0;
        for (int j = 0; j < tmp.size(); j++) { // 所有id是mID的都要释放内存
            int start = tmp.get(j);
            int index = -1;
            for (int i = 0; i < list.size();
                 i++) { // 可以用二分查找优化，list是有序的
                if (list.get(i)[0] == start) {
                    index = i;
                    break;
                }
            }
            ans += list.get(index)[1]; // 数组的第二个位置是分配的长度
            list.remove(index); // 释放内存，从list中删除
        }
        map.remove(mID); // 释放内存，从map中删除
        return ans;
    }
}
