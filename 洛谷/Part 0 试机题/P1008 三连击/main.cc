#include <iostream>
#include <algorithm>

using namespace std;
int main() {
    int nums[]{1,2,3,4,5,6,7,8,9};
    do
    {
        int a = nums[0]*100+nums[1]*10+nums[2];
        if(a*3>=1000)
            break;
        int b = nums[3]*100+nums[4]*10+nums[5];
        if(a*2==b){
            int c = nums[6]*100+nums[7]*10+nums[8];
            if(c==3*a)
                cout<<a<<" "<<b<<" "<<c<<endl;
        }
    }while(next_permutation(nums,nums+9));
}