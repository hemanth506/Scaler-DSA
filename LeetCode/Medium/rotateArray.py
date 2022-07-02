class Solution:
    def reverseArray(self, nums, f, e):
        while f < e:
            temp = nums[f]
            nums[f] = nums[e]
            nums[e] = temp
            f += 1
            e -= 1
        return nums
    
    def rotate(self, nums, k):
        if len(nums) != 1:
            f = 0
            e = len(nums) - 1
            nums = self.reverseArray(nums, f, e)

            k = k % len(nums)
            f = 0
            e = k - 1
            nums = self.reverseArray(nums, f, e)

            f = k
            e = len(nums) - 1
            nums = self.reverseArray(nums, f, e)

            return nums
        return nums
        
items = [1, 2]
times = 3
soln = Solution()
print(soln.rotate(items, times))