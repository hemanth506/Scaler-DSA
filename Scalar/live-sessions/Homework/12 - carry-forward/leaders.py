class Solution:
    def solve(self, A):
        N = len(A)
        leader = []
        leader.append(A[N - 1])
        count = 1
        for i in range(N - 2, -1, -1):
            if A[i] > leader[-1]:
                leader.append(A[i])
                count += 1
        return count,leader


A = [16, 17, 4, 3, 5, 2]
soln = Solution()
print(soln.solve(A))