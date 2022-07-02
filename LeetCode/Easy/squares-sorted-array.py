class Solution:
    def sortedSquares(self, nums):
        for i in range(len(nums)):
            temp = nums[i]**2
            nums.pop(i)
            nums.insert(i, temp)
        nums.sort()
        return nums
        
nums = [-4,-1,0,3,10]
soln = Solution()
print(soln.sortedSquares(nums))