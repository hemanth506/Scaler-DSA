from bisect import bisect_right

class Solution:
    def solve(self, A, B):
        A.sort()
        lenghtOfA = len(A)
        if(B in A):
            elementIndex = bisect_right(A, B)
            return lenghtOfA - elementIndex
        else:
            return -1
        
        
sol = Solution()
print(sol.solve([24, 33, 13, 11, 30, 28, 19, 8, 30, 25, 42, 6, 30, 49, 3, 49, 24, 13, 3, 50], 13))
