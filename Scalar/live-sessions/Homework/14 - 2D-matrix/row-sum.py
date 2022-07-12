class Solution:
    def solve(self, A):
        N = len(A)
        M = len(A[0])

        elt = []
        for i in range(N):
            sumValue = 0
            for j in range(M):
                sumValue += A[i][j]
                # print(i,j)
            elt.append(sumValue)
        return elt

A = [[1,2,3,4],
    [5,6,7,8],
    [9,2,3,4]]
soln = Solution()
print(soln.solve(A))
