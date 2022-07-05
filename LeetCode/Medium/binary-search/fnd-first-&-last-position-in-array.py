class Solution:
    def binarySearch(self, nums, target):
        l = 0
        N = len(nums) 
        h = N - 1
        print(N)

        checkRightSide = False 
        resp = []
        while l <= h:
            m = l + ((h - l) // 2)

            if nums[m] < target:
                l = m + 1
            elif nums[m] > target:
                h = m - 1
            else:
                # return m
                if not checkRightSide:
                    if nums[m] != nums[m - 1]:
                        resp.append(m)
                        l = m
                        h = N - 1
                        checkRightSide = True
                    else:
                        # h = m
                        print("else => ",N)
                        if N == 2:
                            print(m)
                            if N != m + 1:
                                if nums[m] == nums[m + 1]:
                                    resp.append(m)
                                    resp.append(m + 1)
                                    return resp
                            else:
                                resp.append(m)
                                resp.append(m)
                                return resp
                        if N == 1:
                            resp.append(m)
                            resp.append(m)
                            return resp
                        else:
                            h = m
                
                if checkRightSide:
                    print("right side", N, m)
                    if N != m and N != m + 1: # 
                        if nums[m] != nums[m + 1]:
                            resp.append(m)
                            return resp
                        else:
                            l = m + 1
                    else:
                        resp.append(m)
                        return resp
        return -1


    def searchRange(self, nums, target):
        found = self.binarySearch(nums, target)
        if found == -1:
            res = [-1, -1]
        else:
            res = found
        return res




nums = [5, 7, 7, 8, 8, 8, 8, 8, 10]
target = 8

# nums = [1]
# target = 1

# nums = [1,4]
# target = 4

# nums = [1,2, 2]
# target = 2

nums = [3, 3 , 3, 3]
target = 3
soln = Solution()
print(soln.searchRange(nums, target))
        