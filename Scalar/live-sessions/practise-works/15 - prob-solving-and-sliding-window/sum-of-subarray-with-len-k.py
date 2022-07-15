from tkinter import E


class Solution:
    def solve(self, A, k):
        N = len(A)
        sumValue = 0
        for i in range(k):
            sumValue += A[i]

        # print(sumValue)

        ans = sumValue
        e = k
        for i in range(1, N - k + 1):
            # print(i-1, i, e)
            sumValue = sumValue - A[i - 1] + A[e]
            if ans < sumValue:
                ans = sumValue
            e += 1
            
        return ans

A = [-3,4,-2,5,3,-2,8,2,1,4]
k = 5
soln = Solution()
print(soln.solve(A, k))