class Solution:
    def solve(self, A, B):

        for i in range(len(A)):
            for j in range(len(A[i])):
                A[i][j] = A[i][j] + B[i][j]
        return A

A = [[1, 2, 3, 4],[4, 5, 6],[7, 8, 9]]
B = [[9, 8, 7, 6],[6, 5, 4],[3, 2, 1]]
soln = Solution()
print(soln.solve(A,B))