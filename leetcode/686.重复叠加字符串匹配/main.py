class Solution:
    def repeatedStringMatch(self, a: str, b: str) -> int:
        if a==b:
            return 1
        if b=="":
            return 0 
        if a not in b:
            if b in a:
                return 1      
        count=3
        temp = a 
        a+=temp
        if b in a:
            return 2
        a+=temp
        if b in a:
            return 3
        while len(a)<2*len(b):
            a+=temp
            count+=1
            if b in a:
                return count 
        return -1