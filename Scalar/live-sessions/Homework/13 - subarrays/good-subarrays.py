class Solution:
    def solve(self, A, B):
        N = len(A)
        totalCount = 0
        for i in range(N):
            length = 0
            total = 0
            for j in range(i, N):
                total += A[j]
                length += 1
                # print(i, j, length, total)
                if length % 2 == 0 and total < B:
                        totalCount += 1
                elif length % 2 != 0 and total > B:
                        totalCount += 1
        return totalCount



A = [1, 2, 3, 4, 5]
B = 4

A = [13, 16, 16, 15, 9, 16, 2, 7, 6, 17, 3, 9]
B = 65
soln = Solution()
print(soln.solve(A,B))
