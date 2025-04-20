#include <bits/stdc++.h>
using namespace std;


bool strCmp(string s1,string s2){
    int pos1 = 0;
    int pos2 = 0;
    if(s1.size()!=s2.size()){
        return s1.size()>s2.size();
    }
    while(pos1<s1.size()&&pos2<s2.size()){
        char ch1 = s1[pos1];
        char ch2 = s2[pos2];
        if(ch1!=ch2){
            return ch1>ch2;
        }
        pos1++;
        pos2++;
    }
    return true;
}
int main()
{
    int n;
    cin>>n;
    vector<int> vector1;
    for(int i=0;i<n;i++){
        int temp;
        cin>>temp;
        vector1.emplace_back(temp);
    }
    sort(vector1.begin(),vector1.end(),[](int a,int b){
        string s1 = to_string(a)+ to_string(b);
        string s2 = to_string(b)+ to_string(a);
        return strCmp(s1,s2);
    });
    string ans = "";
    for(int m:vector1){
        ans+= to_string(m);
    }
    cout<<ans<<endl;
}