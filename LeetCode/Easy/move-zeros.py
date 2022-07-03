class Solution:
    def moveZeroes(self, nums):
        N = len(nums)

        count = 0
        for i in range(N):
            if nums[i] != 0:
                nums[count] = nums[i]
                count += 1

        for j in range(count, N):
            nums[j] = 0
        
        return nums

        
nums = [0, 1, 0, 3, 12]
# nums = [0,0,1]
soln = Solution()
print(soln.moveZeroes(nums))