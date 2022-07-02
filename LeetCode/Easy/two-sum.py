# did this in O(N) instead of O(N^2)

'''
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

 

Example 1:
Input: nums = [2,7,11,15], target = 9

Output: 
[0,1]

Explanation: 
Because nums[0] + nums[1] == 9, we return [0, 1].

'''


class Solution:
    def twoSum(self, nums, target):

        values = {}
        for idx, value in enumerate(nums):
            if target - value in values:
                return [values[target - value], idx]
            else:
                values[value] = idx

# nums = [2,7,11,15]
# target = 9

# nums = [3,3]
# target = 6

nums = [3,2,4]
target = 6
soln = Solution()
print(soln.twoSum(nums, target))