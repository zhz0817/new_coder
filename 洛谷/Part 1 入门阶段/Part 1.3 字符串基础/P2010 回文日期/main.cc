#include<cstdio>
using namespace std;
int main()
{
    int i,j,n,m,c,sum,ans;
    ans=0;
    int s[13]={0,31,29,31,30,31,30,31,31,30,31,30,31};
    scanf("%d%d",&n,&m);
    for (i=1;i<=12;i++)//枚举月和日
        for (j=1;j<=s[i];j++)
        {
            c=(j%10)*1000+
              (j/10)*100+
              (i%10)*10+
              (i/10);//算出前四位。
            sum=c*10000+i*100+j;//算出整个日期
            if (sum<n||sum>m)
                continue;
            ans++;//统计
        }
    printf("%d",ans);
    return 0;
}