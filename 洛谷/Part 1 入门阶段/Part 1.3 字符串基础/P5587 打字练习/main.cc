#include <string>
#include <vector>
#include <iostream>
#include <math.h>
using namespace std;
template <typename T>
void filter(vector<T>& vector1,T val){
    int size = vector1.size();
    for(int i=0;i<size;i++){
        vector1[i]=val;
    }
}

int main()
{
    std::vector<std::string> vector_string;
    std::string s;
    do{
        getline(cin,s);
        string t = "";
        for(int i=0;i<s.size();i++){
            char ch = s[i];
            if(s[i]=='<'){
                if(t.size()>=1){
                    t = t.substr(0,t.size()-1);
                }
            }
            else{
                t+=ch;
            }
        }
        s = t;
        if(s=="EOF"){
            break;
        }
        vector_string.emplace_back(s);
    } while (true);
    int index = 0;
    int ans = 0;
    do{
        getline(cin,s);
        if(s=="EOF"){
            break;
        }
        if(index>=vector_string.size()){
            break;
        }
        string t = "";
        for(int i=0;i<s.size();i++){
            char ch = s[i];
            if(s[i]=='<'){
                if(t.size()>=1){
                    t = t.substr(0,t.size()-1);
                }
            }
            else{
                t+=ch;
            }
        }
        s = t;
        int index1 = 0;
        int index2 = 0;
        while(index1<s.length()&&index2<vector_string[index].size()){
            char ch1 = s[index1];
            char ch2 = vector_string[index][index2];
            if(ch1==ch2){
                if(ch1=='.'||ch1==' '||(ch1>='a'&&ch1<='z'))
                    ans++;
            }
            index1++;
            index2++;
        }
        index++;
    } while (true);
    int n;
    cin>>n;
    cout<<(long long)(ans*60/n+0.5)<<endl;
    return 0;
}