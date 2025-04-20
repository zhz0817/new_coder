// #include <iostream>
// #include <unistd.h>
// #include <string.h>
// #include <vector>
#include <bits/stdc++.h>
#include <vector>
#include <string>
std::vector<std::string> split(std::string s);
std::vector<std::string> split(std::string s,char ch){
    std::vector<std::string> ans;
    std::string t = "";
    for(int i=0;i<s.size();i++){
        char ch1 = s[i];
        if(ch1==ch){
            ans.push_back(t);
            t = "";
        }else{
            t+=ch1;
        }
    }
    ans.push_back(t);
    return ans;
}
int main(){
    std::string s;
    std::cin>>s;
    std::vector<std::string> vectors = split(s,'-');
    int val = 0;
    int count = 1;
    for(int i=0;i<vectors.size()-1;i++){
        std::string t = vectors[i];
        for(int j=0;j<t.size();j++){
            val+=count*(t[j]-'0');
            count++;
        }
    }
    val%=11;
    bool flag = false;
    char ch = vectors[vectors.size()-1][0];
    if(val==10){
        flag = ch=='X';
    }else{
        if(val==vectors[vectors.size()-1][0]-'0'){
            flag = 1;
        }else{
            flag = 0;
        }
    }
    if(flag){
        std::cout<<"Right"<<std::endl;
    }else{
        std::string t = "";
        for(int i=0;i<vectors.size()-1;i++){
            t+=vectors[i];
            t+='-';
        }
        if(val==10){
            t+='X';
        }else{
            t+=(val+'0');
        }
        std::cout<<t<<std::endl;
    }
    return 0;
}