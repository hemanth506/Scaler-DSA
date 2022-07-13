'''
If I use list[], it will append the index value multiple times, so this approach returns TLE.
But when I use set(), it will not allow duplicates and the code is working fine.
'''

class Solution:
    def solve(self, A):
        N = len(A)
        M = len(A[0])
        
        # row = []
        # column = []
        row = set()
        column = set()
        for i in range(N):
            AILen = len(A[i])
            l = 0
            h = AILen - 1
            while l <= h:
                if A[i][l] == 0:
                    row.add(i)
                    column.add(l)
                if A[i][h] == 0:
                    row.add(i)
                    column.add(h)
                l += 1
                h -= 1

                    
        # print(row)
        # print(column)

        '''
        Suggestion from TA: [Both are same]

        row = set()
        column = set()
        for i in range(N):
            for j in range(M):
                if A[i][j] == 0:
                    row.add(i)
                    column.add(j)

        '''
        

        for l in range(N):
            for k in range(M):
                if l in row:
                    A[l][k] = 0
                if k in column:
                    A[l][k] = 0

        return A

A = [[1,2,3,4],
    [5,6,7,0],
    [9,2,0,4]]

soln = Solution()
print(soln.solve(A))
