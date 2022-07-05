'''
to find only the even indexes sum, we can make the odd indexes value to "0" and find prefix for that
'''

class Solution:
    def findEvenSum(self, arr, ranges):

        N = len(arr)
        prefixEven = [0] * N

        # finding prefix here
        prefixEven[0] = arr[0]
        for i in range(1, N):
            if i % 2 == 0:
                prefixEven[i] = prefixEven[i - 1] + arr[i]
            else:
                prefixEven[i] = prefixEven[i - 1]

        print(prefixEven)

        allValueRanges = []
        for i in range(len(ranges)):
            left = ranges[i][0]
            right = ranges[i][1]

            if left == 0:
                value = prefixEven[right]
            else:
                value = prefixEven[right] - prefixEven[left - 1]


            # print(value)
            allValueRanges.append(value)
        return allValueRanges

#      0  1  2  3  4   5  6  7  8
arr = [3, 2, 1, 6, -3, 2, 8, 4, 9]
ranges = [[1, 4], [2, 7], [3, 8], [0, 4]]
soln = Solution()
print(soln.findEvenSum(arr, ranges))