class NumArray:

    def __init__(self, nums):
        self.nums = nums

        prefix = [0] * len(nums)
        prefix[0] = nums[0]
        for i in range(1, len(nums)):
            prefix[i] = prefix[i - 1] + nums[i]
        print(prefix)
        self.prefix = prefix

    def sumRange(self, left, right):
        tempPrefix = self.prefix
        N = len(tempPrefix)
        if left != 0:
            return tempPrefix[right] - tempPrefix[left - 1]
        else:
            return tempPrefix[right]
        

nums = [-2, 0, 3, -5, 2, -1]
left, right = [2, 5]
obj = NumArray(nums)
param_1 = obj.sumRange(left,right)
print(param_1)