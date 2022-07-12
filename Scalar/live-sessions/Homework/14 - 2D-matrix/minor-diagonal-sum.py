class Solution:
    def solve(self, A):
        N = len(A)
        j = N - 1
        addition = 0
        for i in range(N):
            # print(i, j)
            addition += A[i][j]
            j -= 1

        return addition


A = [[1, -2, -3],
      [-4, 5, -6],
      [-7, -8, 9]]
soln = Solution()
print(soln.solve(A))
