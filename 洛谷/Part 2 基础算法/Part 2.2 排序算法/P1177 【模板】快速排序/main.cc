#include <bits/stdc++.h>
using namespace std;
typedef unsigned long long ull;
typedef long long ll;
#define max_int INT_MAX;
#define min_int INT_MIN;

int part(int* nums,int low,int high){
    int i=low,j=high;
    int flag = nums[low];
    while ((i<j))
    {
        /* code */
        while(i<j&&nums[j]>flag){
            j--;
        }
        if(i<j){
            swap(nums[i],nums[j]);
            i++;
        }
        while(i<j&&nums[i]<flag){
            i++;
        }
        if(i<j){
            swap(nums[i],nums[j]);
            j--;
        }
    }
    nums[i] = flag;
    return i;
    
}
void quick_sort(int* nums,int left,int right){
    if(left<right){
        int mid = part(nums,left,right);
        quick_sort(nums,left,mid);
        quick_sort(nums,mid+1,right);
    }
}
int main(){
    int n;
    cin>>n;
    // int nums[n];
    vector<int> nums;
    for(int i=0;i<n;i++){
        int temp;
        cin>>temp;
        // nums[i]=temp;
        nums.emplace_back(temp);
    }
    // quick_sort(nums,0,n-1);
    sort(nums.begin(),nums.end());
    for (int i = 0; i < n; i++)
    {
        if(i==n-1){
            cout<<nums[i]<<endl;
        }
        else{
            cout<<nums[i]<<" ";
        }
    }
    return 0;
}
