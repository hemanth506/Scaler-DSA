class Solution(object):
    def pivotIndex(self, nums):
        
        N = len(nums)
        prefix = [0] * N
        prefix[0] = nums[0]
        for i in range(1, N):
            prefix[i] = prefix[i - 1] + nums[i]
            
        print(prefix)
        prefixArr = []
        for i in range(N):
            
            left = 0
            if i != 0:
                left = prefix[i - 1]
                
            right = prefix[N - 1] - prefix[i]

            print(left, right)
            if left == right:
                prefixArr.append(i)

        if len(prefixArr) != 0:
            return prefixArr[0]
        else:
            return -1
            
        
nums = [1,7,3,6,5,6]
soln = Solution()
print(soln.pivotIndex(nums))