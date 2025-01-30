class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        ans = []
        dict1 = {}
        dict2 =  {}
        for n in nums1:
            if n in dict1:
                dict1[n]+=1
            else:
                dict1[n]=1
        for n in nums2:
            if n in dict2:
                dict2[n]+=1
            else:
                dict2[n]=1
        for k,v in dict1.items():
            if k in dict2:
                min1 = min(v,dict2[k])
                for i in range(min1):
                    ans.append(k)
        return ans
        