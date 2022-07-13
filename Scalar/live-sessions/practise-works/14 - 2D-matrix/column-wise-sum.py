
class Solution:
    def solve(self, A):

        N = len(A)
        M = len(A[0])

        eltList = []
        for i in range(M):
            sumValue = 0
            for j in range(N):
                sumValue += A[j][i]
                print(j, i)
            eltList.append(sumValue)
        return eltList





A = [[1,2,3,4],
    [5,6,7,0],
    [9,2,0,4]]

soln = Solution()
print(soln.solve(A))