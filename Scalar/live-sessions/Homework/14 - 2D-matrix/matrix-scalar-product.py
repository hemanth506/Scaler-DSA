class Solution:
    def solve(self, A, B):
        N = len(A)
        M = len(A[0])
        for i in range(N):
            for j in range(M):
                print(A[i][j])
                A[i][j] *= B
        return A

A = [[1, 2, 3],[4, 5, 6],[7, 8, 9]]
B = 2

A = [[7],[10]]
B = 4
soln = Solution()
print(soln.solve(A, B))