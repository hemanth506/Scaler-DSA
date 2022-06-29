from bisect import bisect_right


class Solution:
    def solve(self, A, B):
        for i in range(1, len(A)):
            A[i] += A[i - 1]
        for i in range(0, len(B)):
            print(A, B[i])
            print(bisect_right(A, B[i]))
            B[i] = bisect_right(A, B[i])
            
        return B
        
sol = Solution()
print(sol.solve([3, 4, 4, 6], [20, 4, 10, 2]))
