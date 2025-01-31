class Solution:
    def reverseStr(self, s: str, k: int) -> str:
        a=list(s)
        l=len(a)
        d=[]
        for i in range(0,l,2*k):
            if l-i>=2*k:
                t=a[i:i+k]
                t.reverse()
                t+=a[i+k:i+2*k]
            else:
                if l-i<=k:
                    t=a[i:]
                    t.reverse()
                else:
                    t=a[i:i+k]
                    t.reverse()
                    t+=a[i+k:]
            d+=t
        return "".join(d)