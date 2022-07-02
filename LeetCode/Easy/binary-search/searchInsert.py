class Solution:
    def search(self, nums, target):
        l = 0
        h = len(nums) - 1
        while h >= l:
            m = (h + l) // 2
            if target > nums[m]:
                l = m + 1
            elif target < nums[m]:
                h = m - 1
            else:
                return m
        return l
        
nums = [-1,0,3,5,9,12]
# nums = [1,3,5,6]
target = 8

soln = Solution()
print(soln.search(nums, target))