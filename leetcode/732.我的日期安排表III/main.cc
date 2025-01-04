class MyCalendarThree {
public:
    struct Compare1 { //类内结构体
        bool operator()(const int& a, const int& b) const {//严格要求带有const，否则报错无法编译
            return a<b;
        }
    };
    map<int,int,MyCalendarThree::Compare1> map1;
    MyCalendarThree() {

    }

    int book(int startTime, int endTime) {
        int ans = 0;
        int max = 0;
        map1[startTime]++;
        map1[endTime]--;
        for(const auto& iter:map1){
            int val = iter.second;
            max += val;
            ans = std::max(ans,max);
        }
        return ans;
    }
};

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree* obj = new MyCalendarThree();
 * int param_1 = obj->book(startTime,endTime);
 */