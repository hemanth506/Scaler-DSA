'''
used carry forward instead of prefix.
'''

class Solution:
    def solve(self, A, B):

        N = len(A)
        print(A)

        count = 0
        for i in range(N):
            value = 0
            for j in range(i, N):
                value += A[j] 
                print("value => ", value)
                if value < B:
                    count += 1

        return count




A, B = [[2, 5, 6], 10]
A, B = [[ 15, 8, 16 ], 242]
soln = Solution()
print(soln.solve(A,B))
