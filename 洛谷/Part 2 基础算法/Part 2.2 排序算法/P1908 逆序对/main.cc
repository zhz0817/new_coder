#include<cstdio> 
#include<iostream> 
#include<cstring> 
#include<algorithm>
using namespace std; 
#define maxn 1111111 
//typedef long long ll; 
struct node
{
	int val,pos;
} a[maxn]; int b[maxn]; int n;
int cmp(node a,node b)
{
	if(a.val!=b.val)//值不同按数值升序排
	return a.val<b.val;
	return a.pos<b.pos;//值相同则按位置升序排
}
int getsum(int x)//求前缀和
{
	int sum=0; while(x>0)
	{
		sum+=b[x]; x-=x&-x;
	}
	return sum;
}
void update(int x,int v)//单点更新
{
	while(x<=maxn)
	{
		b[x]+=v; x+=x&-x;
	}
}
int main()
{
	//while(scanf("%d",&n)!=EOF)
	//{
		scanf("%d",&n);
		memset(b,0,sizeof(b));//初始化
		for(int i=0;i<n;i++)
		{
	 		scanf("%d",&a[i].val);
			a[i].pos=i+1;//记录每个值的位置
		}
		sort(a,a+n,cmp);//排序
		long long ans=0;
		for(int i=n-1;i>=0;i--)//倒着插点
		{
			ans+=getsum(a[i].pos);
			update(a[i].pos,1);
		}
		//printf("%d\n",ans);
		cout<<ans;
	//}
	return 0;
}