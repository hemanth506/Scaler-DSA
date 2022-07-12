class Solution:
    def solve(self, A, B):
        N = len(A)
        M = len(A[0])

        notEqual = False
        for i in range(N):
            for j in range(M):
                # print(i,j)
                if A[i][j] != B[i][j]:
                    notEqual = True
                    break

        
        return 1 if not notEqual else 0

A = [[1, 2, 3],[4, 5, 6],[7, 8, 9]]
B = [[1, 2, 3],[4, 5, 6],[7, 8, 9]]
soln = Solution()
print(soln.solve(A, B))