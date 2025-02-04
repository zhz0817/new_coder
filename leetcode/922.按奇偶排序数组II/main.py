class Solution:
    def sortArrayByParityII(self, nums: List[int]) -> List[int]:
        odd = []
        even = []
        for num in nums:
            if num % 2 == 0:
                even.append(num)
            else:
                odd.append(num)
        ans = []
        index1 = 0
        index2 = 0
        n = len(nums)
        for i in range(n):
            if i %2 == 0:
                ans.append(even[index1])
                index1 += 1
            else:
                ans.append(odd[index2])
                index2 += 1
        return ans

        