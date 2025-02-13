
class Solution:
    def fun(self,m):
        count=0
        while m!=0:
            count+=m%10
            m//=10
        return count


    def countBalls(self, lowLimit: int, highLimit: int) -> int:
        a={}
        ans = -1
        for i in range(lowLimit,highLimit+1):
            temp = self.fun(i)
            if temp not in a:
                a[temp]=1
            else:
                a[temp]+=1
            ans = max(ans,a[temp])
        return ans