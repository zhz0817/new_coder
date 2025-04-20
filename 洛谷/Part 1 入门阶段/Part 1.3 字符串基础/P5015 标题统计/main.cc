#include <iostream>
#include <cstdio>
#include <cstring>

using namespace std;
int main() {
     char chs[10];
     gets(chs);
     int n = strlen(chs);
     int ans = 0;
     for(int i=0;i<n;i++){
         char ch = chs[i];
         if(ch>='A'&&ch<='Z')
             ans++;
         else if(ch>='a'&&ch<='z')
             ans++;
         else if(ch>='0'&&ch<='9')
             ans++;
     }
     cout<<ans<<endl;
}