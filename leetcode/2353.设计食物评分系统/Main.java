class Pair {
    String foodName;
    Integer value;

    public Pair(String foodName, int value) {
        this.foodName = foodName;
        this.value = value;
    }
}
class FoodRatings {
    Map<String, TreeSet<Pair>> map;//TreeSet做排序，key存储食物类型，pair存储食物名称和评分
    Map<String, String> map1;//key是食物名，value是食物类型
    Map<String, Pair> map2;//key是食物名，value是pair
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        map = new HashMap<>();
        map1 = new HashMap<>();
        map2 = new HashMap<>();
        int n = foods.length;
        for (int i = 0; i < n; i++) {
            String foodType = cuisines[i];
            map1.put(foods[i], foodType);
            Pair pair = new Pair(foods[i], ratings[i]);
            if (map.containsKey(foodType)) {
                map.get(foodType).add(pair);
            } else {
                TreeSet<Pair> set = new TreeSet<>(new Comparator<Pair>() {//自定义比较器
                    @Override
                    public int compare(Pair o1, Pair o2) {
                        int value = o2.value.compareTo(o1.value);
                        if (value != 0) {//按照评分从大到小排序
                            return value;
                        }
                        return o1.foodName.compareTo(o2.foodName);//如果评分相同，按照字典序从小到大排序
                    }
                });
                set.add(pair);
                map.put(foodType, set);
            }
            map2.put(foods[i], pair);
        }
    }

    public void changeRating(String food, int newRating) {
        String foodType = map1.get(food);
        Pair tmp = map2.get(food);
        map.get(foodType).remove(tmp);//删除以前的记录
        tmp.value = newRating;
        map.get(foodType).add(tmp);//插入新记录，自动按照比较器排序
        //这里可能有同学会觉得，在pair中重写hashcode和equals然后直接修改map行不行，代码如下：
        // String foodType = map1.get(food);
        // map.get(foodType).remove(new Pair(food,0));
        // map.get(foodType).add(new Pair(food,newRating));
        // 我试过了不可以，因为TreeSet会更优先使用比较器去判断对象是否相同，然后才是hashcode和equals。所以会出现问题
        // 因此创建map2保存pair
        // 而如果直接修改pair，没有插入和删除操作，比较器可能不会被触发，那么第一个元素就不是最大的元素，也不能这样做。
    }

    public String highestRated(String cuisine) {
        return map.get(cuisine).first().foodName;//获取第一个元素就是评分最高的元素
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */