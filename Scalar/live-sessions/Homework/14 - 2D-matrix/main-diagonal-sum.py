class Solution:
    def solve(self, A):
        N = len(A)
        sumValue = 0
        for i in range(N):
            sumValue += A[i][i]

        return sumValue


A = [[1, -2, -3],
      [-4, 5, -6],
      [-7, -8, 9]]

soln = Solution()
print(soln.solve(A))

