class Solution:
    def findSpecialIndex(self, arr):
        N = len(arr)

        # even
        prefixEven = [0] * N
        prefixEven[0] = arr[0]
        for i in range(1, N):
            if i % 2 == 0:
                prefixEven[i] = prefixEven[i - 1] + arr[i]
            else:
                prefixEven[i] = prefixEven[i - 1]
        print(prefixEven)

        # odd
        prefixOdd = [0] * N
        prefixOdd[0] = 0
        for j in range(1, N):
            if j % 2 == 1:
                prefixOdd[j] = prefixOdd[j - 1] + arr[j]
            else:
                prefixOdd[j] = prefixOdd[j - 1]
        print(prefixOdd)
        

        count = 0
        for k in range(N):
            leftEven = 0
            if k != 0:
                leftEven = prefixEven[k - 1]
                
            rightEven = prefixOdd[N - 1] - prefixOdd[k]
            even = leftEven + rightEven

            leftOdd = 0
            if k != 0:
                leftOdd = prefixOdd[k - 1]
            
            rightOdd = prefixEven[N - 1] - prefixEven[k]
            odd = leftOdd + rightOdd

            if even == odd:
                count += 1


        return count


#        0  1  2  3  4  5  6  7  8  9  10  11
# arr = [2, 1, 3, 0, 6, 7, 3, 4, 5, 6, 10, 2]
arr = [4, 3, 2, 7, 6, -2]
soln = Solution()
print(soln.findSpecialIndex(arr))

'''
[2, 2, 5, 5, 11, 11, 14, 14, 19, 19, 29, 29]

[0, 1, 1, 1, 1, 8, 8, 12, 12, 18, 18, 20]
'''