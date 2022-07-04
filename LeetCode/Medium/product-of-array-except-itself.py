class Solution(object):
    def productExceptSelf(self, nums):
        
        N = len(nums)
        prefix = [0 for i in nums]
        prefix[0] = nums[0]
        for i in range(1, len(nums)):
            prefix[i] = prefix[i - 1] * nums[i]

        print(prefix)

        suffix = [0 for i in nums]
        suffix[N - 1] = nums[N - 1]
        for i in range(N - 2, -1, -1):
            suffix[i] = suffix[i + 1] * nums[i]

        print(suffix)
        res = [0 for i in nums]
        for i in range(N):
            if i == 0:
                res[i] = suffix[ i + 1]
            elif i > 0 and i < N - 1:
                res[i] = prefix[i - 1] * suffix[i + 1]
            else:
                print(i)
                res[i] = prefix[i - 1]

        return res

       


nums = [1,2,3,4]

# nums = [-1,1,0,-3,3]
nums = [2,3,1,2,4,3]
soln = Solution()
print(soln.productExceptSelf(nums))